package com.example.btvn_day_3.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpsertCourseRequest {
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Description is required")
    @Size(min = 50, message = "Length of description muste grater than 50")
    private String description;
    @NotBlank(message = "Type is required")
    private String type;
    private List<String> topics;
    private String thumbnail;
    private int userId;
}
