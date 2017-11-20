package com.johnwu.bookstorebackend.service;

import java.util.Set;

import com.johnwu.bookstorebackend.domain.security.User;
import com.johnwu.bookstorebackend.domain.security.UserRole;

public interface UserService {
	User createUser(User user, Set<UserRole> userRoles);
}
