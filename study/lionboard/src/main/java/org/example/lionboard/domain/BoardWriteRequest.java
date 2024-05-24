package org.example.lionboard.domain;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class BoardWriteRequest {
    @Id
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String password;

    @NotEmpty
    private String title;

    @NotEmpty
    private String content;

}
