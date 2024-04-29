package com.lcx.pojo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @NotNull
    private int mobile;
    @NotEmpty
    private String password;
    @NotNull
    private int age;

    public interface add extends Default{}

    public interface update extends Default{}
}
