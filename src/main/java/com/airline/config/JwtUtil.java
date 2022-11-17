//package com.airline.config;
//
//import java.io.Serializable;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.function.Function;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//
//@Component
//public class JwtUtil implements Serializable {
//
//	
//	
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = -6508502105485517262L;
//
//	public static final long JWT_VALIDITY = 5*60*60;
//
//	@Value("")
//	private static final String SECRET_KEY =  "secret";
//
//	public static String getUsernameFromToken(String token) {
//		return getClaimFromToken(token, Claims::getSubject);
//	}
//
//	public static Date getIssuedAtDateFromToken(String token) {
//		return getClaimFromToken(token, Claims::getIssuedAt);
//	}
//
//	public static Date getExpirationDateFromToken(String token) {
//		return getClaimFromToken(token, Claims::getExpiration);
//	}
//
//	public static <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
//		final Claims claims = getAllClaimsFromToken(token);
//		return claimsResolver.apply(claims);
//	}
//
//	public static Claims getAllClaimsFromToken(String token) {
//		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
//	}
//
//	private static Boolean isTokenExpired(String token) {
//		final Date expiration = getExpirationDateFromToken(token);
//		return expiration.before(new Date());
//	}
//
//	public Boolean ignoreTokenExpiration(String token) {
//		return false;
//	}
//
//	public static String generateToken(UserDetails userDetails) {
//		Map<String, Object> claims = new HashMap<>();
//		return doGenerateToken(claims, userDetails.getUsername());
//	}
//
//	public static String doGenerateToken(Map<String, Object> claims, String subject) {
//
//		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
//				.setExpiration(new Date(System.currentTimeMillis() + JWT_VALIDITY*1000)).signWith(SignatureAlgorithm.HS512, SECRET_KEY).compact();
//	}
//
//	public static Boolean validateToken(String token, UserDetails userDetails) {
//		final String username = getUsernameFromToken(token);
//		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
//	}
//}
