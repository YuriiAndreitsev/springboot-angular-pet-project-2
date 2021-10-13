package ua.com.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleAuthorDTO {
    private String articleId;
    private String articleTitle;
    private String articleContent;
    private String authorName;
    private LocalDateTime articlePostDateTime;
}
