package com.example.stin.Users.UserDetails;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class UserEntityTest {
    @Test
    void testConstructor() {
        UserEntity actualUserEntity = new UserEntity();
        actualUserEntity.setEmail("jane.doe@example.org");
        actualUserEntity.setId(1L);
        actualUserEntity.setName("Name");
        actualUserEntity.setPassword("iloveyou");
        actualUserEntity.setRole("Role");
        actualUserEntity.setSurname("Doe");
        String actualToStringResult = actualUserEntity.toString();
        assertEquals("jane.doe@example.org", actualUserEntity.getEmail());
        assertEquals(1L, actualUserEntity.getId().longValue());
        assertEquals("Name", actualUserEntity.getName());
        assertEquals("iloveyou", actualUserEntity.getPassword());
        assertEquals("Role", actualUserEntity.getRole());
        assertEquals("Doe", actualUserEntity.getSurname());
        assertEquals("UserEntity{id=1, email='jane.doe@example.org', password='iloveyou', name='Name', surname='Doe'}",
                actualToStringResult);
    }

    @Test
    void testConstructor2() {
        UserEntity actualUserEntity = new UserEntity("jane.doe@example.org", "iloveyou", "Name", "Doe", "Role", 1);
        actualUserEntity.setEmail("jane.doe@example.org");
        actualUserEntity.setId(1L);
        actualUserEntity.setName("Name");
        actualUserEntity.setPassword("iloveyou");
        actualUserEntity.setRole("Role");
        actualUserEntity.setSurname("Doe");
        String actualToStringResult = actualUserEntity.toString();
        assertEquals(1, actualUserEntity.getCode().intValue());
        assertEquals("jane.doe@example.org", actualUserEntity.getEmail());
        assertEquals(1L, actualUserEntity.getId().longValue());
        assertEquals("Name", actualUserEntity.getName());
        assertEquals("iloveyou", actualUserEntity.getPassword());
        assertEquals("Role", actualUserEntity.getRole());
        assertEquals("Doe", actualUserEntity.getSurname());
        assertEquals("UserEntity{id=1, email='jane.doe@example.org', password='iloveyou', name='Name', surname='Doe'}",
                actualToStringResult);
    }
    @Test
    void testSetCode() {
        UserEntity userEntity = new UserEntity();
        userEntity.setCode(1);
        assertEquals(1, userEntity.getCode().intValue());
    }

    @Test
    void testEquals() {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail("admi@gmail.com");
        userEntity.setId(1L);
        UserEntity userEntity1 = new UserEntity();
        userEntity1.setEmail("admin@gmail.com");
        userEntity1.setId(1L);
        assertFalse(userEntity.equals(userEntity1));
    }

    @Test
    void testHashCode() {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail("admin@gmail.com");
        UserEntity userEntity1 = new UserEntity();
        userEntity1.setEmail("admin@gmail.com");
        assertEquals(userEntity.hashCode(), userEntity1.hashCode());
    }

    @Test
    void testCanEqual() {
        UserEntity userEntity = new UserEntity();
        assertFalse(userEntity.canEqual("other"));
    }
}

