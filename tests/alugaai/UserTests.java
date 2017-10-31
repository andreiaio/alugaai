package alugaai;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.trocagroup.model.User;

public class UserTests {
	User userValid = new User("Joao da Silva","joaosilva@gmail.com","123123","11900000000","12345678","av sao joao, 123","centro","São Paulo","SP","12312312312");
	User userInvalid = new User("1231 123123 ","joaosilva","","","12348","","","","RQ","123");

	@Test
	public void checkFullName() {
		assertEquals(true, userValid.isNameValid());
		assertEquals(false, userInvalid.isNameValid());
	}

	@Test
	public void checkEmail() {
		assertEquals(true, userValid.isEmailValid());
		assertEquals(false, userInvalid.isEmailValid());
	}
	
	@Test
	public void checkPassword() {
		assertEquals(true, userValid.isPasswordValid());
		assertEquals(false, userInvalid.isPasswordValid());
	}

	@Test
	public void checkCPF() {
		assertEquals(true, userValid.isCPFValid());
		assertEquals(false, userInvalid.isCPFValid());
	}


	@Test
	public void checkCEP() {
		assertEquals(true, userValid.isCEPValid());
		assertEquals(false, userInvalid.isCEPValid());
	}

	@Test
	public void checkState() {
		assertEquals(true, userValid.isStateValid());
		assertEquals(false, userInvalid.isStateValid());
	}


}
