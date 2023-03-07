package executavel;

import bean.BeanPessoa;
import dao.DaoPessoa;

public class Teste {
	public static void main(String[] args) {
		try {
			BeanPessoa beanPessoa = new BeanPessoa();
			beanPessoa.setNome("NOME DA PESSOA33");
			beanPessoa.setMae("NOME MAE2");
			beanPessoa.setPai("NOME PAI2");
			beanPessoa.setNascimentto("10/04/2021");
			beanPessoa.setCpf("000.000.222-20");
			beanPessoa.setRg("2222-2");

			DaoPessoa daoPessoa = new DaoPessoa();

			/* Salvar */
			daoPessoa.salvar(beanPessoa);

			/* Atualizar */
			beanPessoa.setId(1);
			daoPessoa.atualizar(beanPessoa);
			
			/* Deletar */
			daoPessoa.deletar(3);

			/*Listar*/
			for (BeanPessoa listaPessoas : daoPessoa.listar()) {
				System.out.println(listaPessoas.toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
