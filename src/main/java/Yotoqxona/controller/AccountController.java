package Yotoqxona.controller;

import Yotoqxona.security.JwtTokenUtil;
import Yotoqxona.security.UserMaxsus;
import Yotoqxona.security.UserProvider;
import Yotoqxona.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    UserProvider userProvider;


    @Autowired
    private AuthenticationManager authenticationManager;



    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/auth")
    public ResponseEntity<String> login(@RequestBody UserMaxsus userMaxsus) throws Exception {
        try {
            System.out.println(1);
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    userMaxsus.getUsername(), userMaxsus.getPassword()));

        } catch (DisabledException e) {
            System.out.println(2);
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            System.out.println(3);
            throw new Exception("INVALID_CREDENTIALS", e);
        } catch (Exception ex){
            System.out.println(4);
            ex.printStackTrace();
        }

        UserDetails userDetails = userProvider.loadUserByUsername(userMaxsus.getUsername());

        String token = jwtTokenUtil.generateToken(userDetails, true);

        return ResponseEntity.ok(token);

    }
}

