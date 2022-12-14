package com.digitalbooks.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalbooks.exceptions.ResourceAlreadyExist;
import com.digitalbooks.exceptions.RoleNotFound;
import com.digitalbooks.models.ERole;
import com.digitalbooks.models.Role;
import com.digitalbooks.models.User;
import com.digitalbooks.payload.request.LoginRequest;
import com.digitalbooks.payload.request.SignupRequest;
import com.digitalbooks.payload.response.JwtResponse;
import com.digitalbooks.repository.RoleRepository;
import com.digitalbooks.repository.UserRepository;
import com.digitalbooks.security.jwt.JwtUtils;
import com.digitalbooks.security.services.UserDetailsImpl;
import com.digitalbooks.utility.RegistrationResponse;

//@CrossOrigin(origins = "*", maxAge = 3600)
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/digitalbooks")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getEmail(), 
												 roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<RegistrationResponse> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			throw new ResourceAlreadyExist("Already Exist","USERNAME" , signUpRequest.getUsername());
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			throw new ResourceAlreadyExist("Already Exist","EMAIL" , signUpRequest.getEmail());
		}

		// Create new user's account
		User user = new User(signUpRequest.getName(),signUpRequest.getUsername(), 
							 signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()),signUpRequest.getPhoneNumber());

//		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();
		
		
		if(signUpRequest.getUserRole().equals("READER")) {
			
			Role readerRole = roleRepository.findByName(ERole.ROLE_READER)
					.orElseThrow(() -> new RoleNotFound("Not Exist"));
			roles.add(readerRole);
			}
			else if(signUpRequest.getUserRole().equals("AUTHOR")) {
				Role authorRole = roleRepository.findByName(ERole.ROLE_AUTHOR)
						.orElseThrow(() ->  new RoleNotFound("Not Exist"));
				roles.add(authorRole);
			}

/*		if (strRoles == null) {
			if(signUpRequest.getUserRole().equals("READER")) {
				
				Role readerRole = roleRepository.findByName(ERole.ROLE_READER)
						.orElseThrow(() -> new RoleNotFound("Not Exist"));
				roles.add(readerRole);
				}
				else if(signUpRequest.getUserRole().equals("AUTHER")) {
					Role autherRole = roleRepository.findByName(ERole.ROLE_AUTHER)
							.orElseThrow(() ->  new RoleNotFound("Not Exist"));
					roles.add(autherRole);
				}
		}
*/		
/*		else {
			strRoles.forEach(role -> {
				switch (role) {
				case "AUTHER":
					Role autherRole = roleRepository.findByName(ERole.ROLE_AUTHER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(autherRole);

					break;
				
				default:
					Role readerRole = roleRepository.findByName(ERole.ROLE_READER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(readerRole);
				}
			});
		}
*/		
		user.setRoles(roles);
		userRepository.save(user);

		return new ResponseEntity<>(new RegistrationResponse("User Registration successfull !"),HttpStatus.OK);
	}
}
