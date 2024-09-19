package ci.digitalacademyprojet.ecommerce.services.Impl;


import ci.digitalacademyprojet.ecommerce.models.RoleUser;
import ci.digitalacademyprojet.ecommerce.repositories.RoleUserRepository;
import ci.digitalacademyprojet.ecommerce.services.DTO.RoleUserDTO;
import ci.digitalacademyprojet.ecommerce.services.RoleUserService;
import ci.digitalacademyprojet.ecommerce.services.mapper.RoleUserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleUserServiceImp implements RoleUserService {
    private final RoleUserRepository roleUserRepository;
    private final RoleUserMapper roleUserMapper;
    @Override
    public RoleUserDTO save(RoleUserDTO roleUserDTO) {
        RoleUser roleUser = roleUserMapper.toEntity(roleUserDTO);
        return roleUserMapper.toDto(roleUserRepository.save(roleUser));
    }


    @Override
    public RoleUserDTO update(RoleUserDTO roleUserDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {
        roleUserRepository.deleteById(id);
    }

    @Override
    public List<RoleUserDTO> getAll() {
        return roleUserRepository.findAll().stream().map(role -> {
            return roleUserMapper.toDto(role);
        }).toList();
    }

    @Override
    public List<RoleUserDTO> findAll() {
        return roleUserRepository.findAll().stream().map(roleUser -> {
            return roleUserMapper.toDto(roleUser);
        }).toList();
    }
    @Override
    public Optional<RoleUserDTO> findOne(Long id) {
        return roleUserRepository.findById(id)
                .map(roleUserMapper::toDto);
    }

    @Override
    public List<RoleUserDTO> findByRole(String roleUser) {
        return null;
    }

}
