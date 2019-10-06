package br.com.squad1.api.usuario.service;

import br.com.squad1.api.usuario.model.User;
import br.com.squad1.api.usuario.repository.UserRepository;
import com.sun.javafx.scene.control.behavior.OptionalBoolean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalLong;

import static org.mockito.Mockito.mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @Test
    public void testFindById() {
        mockFindUser();
        assertEquals(new Long(1), userServiceImpl.findById(new Long(1)).get().getId());
    }

    private void mockFindUser() {
        List<User> users = new ArrayList<>();
        User user = mock(User.class);
        when(user.getId()).thenReturn(new Long (1));
        when(this.userRepository.findById(new Long(1))).thenReturn(java.util.Optional.of(user));
    }
}