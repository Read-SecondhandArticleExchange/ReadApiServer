package Read.Domain.Main;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class Summary {
	private int accumulateBookCount;
	private int kindOfBook;
	private int requestPossibleBook;
}
