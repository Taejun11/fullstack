package RestingapiBoard.board1.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardDto {
    private Long id;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime createTime;
}
