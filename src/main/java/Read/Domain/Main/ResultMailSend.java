package Read.Domain.Main;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class ResultMailSend {
	private String resultCode;
	private String msg;
}
