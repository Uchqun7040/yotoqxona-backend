package Yotoqxona.service;

import Yotoqxona.service.dto.UserDTO;
import Yotoqxona.service.vm.UserParolVM;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<UserDTO> getAll();
    public UserDTO create(UserDTO data);
    public UserDTO update(UserDTO data);
    public void delete(UserDTO data);
    public void deleteById(Long id);
    Optional<UserDTO> getById(Long id);
    public void changePassword(UserParolVM userParolVM);

}
