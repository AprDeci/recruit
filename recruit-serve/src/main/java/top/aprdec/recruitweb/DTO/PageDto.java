package top.aprdec.recruitweb.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PageDto<T> {
    private long total;
    private List<T> data;
}
