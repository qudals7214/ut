package com.solo.solo.service;

import com.solo.solo.domain.UserRepository;
import com.solo.solo.domain.UserRequestDTO;
import com.solo.solo.domain.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserVO createUser(UserRequestDTO userRequestDTO) {
        UserVO user = new UserVO(userRequestDTO);
        return userRepository.save(user);
    }

    public UserVO readUser(UserRequestDTO userRequestDTO) {
//        UserVO result = userRepository.findById(userRequestDTO.getId()).orElseThrow(
//                () -> new IllegalArgumentException("존재하지 않는 사용자")
//        );
//        if(result.getId().equals(userRequestDTO.getId())){
//            return result;
//        }
//        return null;
        Optional<UserVO> result = userRepository.findById(userRequestDTO.getId());
        UserVO user = result.orElse(null);
        return user;
    }

    public UserVO readUserForId(String id) {
        Optional<UserVO> result = userRepository.findById(id);
        UserVO user = result.orElse(null);
        return user;
    }

    public UserRequestDTO checkId(UserRequestDTO userRequestDTO) {
//        UserVO user =readUser(userRequestDTO);
        UserVO user = readUser(userRequestDTO);
        UserRequestDTO result = new UserRequestDTO();
        if (user == null)
            result.setId("null");
        else
            result.setId(user.getId());

//        String result = Optional.of(user).map(UserVO::getId).orElse("null");
//        String result=user.getId();
        return result;
    }


    public String duplId(UserRequestDTO userRequestDTO) {
//        UserVO user =readUser(userRequestDTO);
        UserVO user = readUser(userRequestDTO);
//        String result = Optional.of(user).map(UserVO::getId).orElse("null");
        String result;
        if (user == null)
            result = "null";
        else
            result = user.getId();
        System.out.println("duplID : " + result);
        return result;
    }


    public List<UserVO> readAllUser(UserRequestDTO userRequestDTO) {
//        return userRepository.findAllOrderd();
//        return userRepository.findAllByOrderOrderByCreatedAtDesc();
        return userRepository.logCheck(userRequestDTO.getId(), userRequestDTO.getPw());
    }

    @Transactional
    public void updateUser(UserRequestDTO userRequestDTO) {
        UserVO user = userRepository.findById(userRequestDTO.getId()).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 사용자")
        );
    }

    @Transactional
    public void deleteUser(UserRequestDTO userRequestDTO) {
        userRepository.deleteById(userRequestDTO.getId());
    }

}
