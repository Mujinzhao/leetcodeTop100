package JacksonTest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName CompanyInfo
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/11/11  5:51 PM
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyInfo {
    private String companyName;

    private Long companyId;
}
