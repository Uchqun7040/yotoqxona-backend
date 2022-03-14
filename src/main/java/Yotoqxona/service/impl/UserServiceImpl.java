package Yotoqxona.service.impl;

import Yotoqxona.entity.User;
import Yotoqxona.repository.UserRepository;
import Yotoqxona.service.UserService;
import Yotoqxona.service.dto.UserDTO;
import Yotoqxona.service.vm.UserParolVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserDTO> getAll() {
        return userRepository.findAll()
                .stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO create(UserDTO data) {
        return null;
    }

    @Override
    public UserDTO update(UserDTO data) {
        return null;
    }

    @Override
    public void delete(UserDTO data) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Optional<UserDTO> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public void changePassword(UserParolVM userParolVM) {

        Optional<User> user=userRepository.findByLogin(userParolVM.getLogin());
        if (user.isPresent() && user.get().getPassword().equals(userParolVM.getEskiParol())){
            user.get().setPassword(userParolVM.getYangiParol());
            userRepository.save(user.get());
        }else{
            throw new RuntimeException("Xatolik ro'y berdi");
        }
    }
}
