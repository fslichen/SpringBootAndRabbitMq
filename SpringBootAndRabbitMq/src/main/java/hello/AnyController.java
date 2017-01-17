package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnyController {
	@Autowired
	private Sender sender;
	
	@RequestMapping(value = "/anyMethod", method = RequestMethod.GET)
	public void anyMethod() {
		sender.send();
	}
}
