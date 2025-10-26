package in.ankit.bind;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Users implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer uid;
	private String uname;
	private Integer age;
}
