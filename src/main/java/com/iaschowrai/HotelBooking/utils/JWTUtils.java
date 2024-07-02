package com.iaschowrai.HotelBooking.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.function.Function;

@Service
public class JWTUtils {

    // Token expiration time: 7 days
    private static final long EXPIRATION_TIME = 1000 * 60 * 24 * 7; // For 7 days


    // Secret key for signing JWTs, initialized in the constructor
     private final SecretKey secretKey;

    // Constructor to initialize the secret key
    public JWTUtils() {
        // Generate a secure random key for HMAC-SHA-256
        this.secretKey = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256);
    }


    // Method to generate a JWT for a UserDetails object
    public String generateToken(UserDetails userDetails){
         return Jwts.builder()
                 // Set the subject of the token as the username
                 .subject(userDetails.getUsername())
                 // Set the issue date of the token to the current time
                 .issuedAt(new Date(System.currentTimeMillis()))
                 // Set the expiration date of the token
                 .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                 // Sign the JWT with the secret key
                 .signWith(secretKey)
                 // Compact the JWT into its final string representation
                 .compact();
     }

    // Method to extract the username from a JWT token
    public String extractUsername(String token){
         return extractClaims(token, Claims::getSubject);
     }

    // Generic method to extract claims from a JWT token using a claims function
    private <T> T extractClaims(String token, Function<Claims, T> claimsTFunction) {
        // Parse and verify the token, then extract the payload (claims)
        return claimsTFunction.apply(Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload());
    }

    // Method to check if a JWT token is valid for a given UserDetails object
    public boolean isValidToken(String token, UserDetails userDetails){
        // Extract the username from the token
        final String username = extractUsername(token);
        // Check if the extracted username matches the UserDetails username and if the token is not expired
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    // Method to check if a JWT token is expired
    private boolean isTokenExpired(String token) {
        // Extract the expiration date from the token and check if it is before the current time
        return extractClaims(token, Claims::getExpiration).before(new Date());
     }

}
