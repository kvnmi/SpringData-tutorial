package com.codewithsage.Springboottutorial.Entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long deptId;
    @NotBlank(message = "Department name is a required field")
    //@Length(max = 15, min = 6) validates length
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;

}
