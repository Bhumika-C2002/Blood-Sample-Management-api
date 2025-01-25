package com.example.Bsm.request;

import com.example.Bsm.entity.User;
import com.example.Bsm.enums.AdminType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminRequest {

    private User user;
    private AdminType adminType;

}
