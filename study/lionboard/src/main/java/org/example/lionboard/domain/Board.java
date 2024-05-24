package org.example.lionboard.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@Builder
public class Board {
    @Id
    private Long id;

    private String name;

    private String password;

    private String content;

    private String title;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
