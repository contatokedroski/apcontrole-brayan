package main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import DAO.PessoaDAO;
import dto.PessoaDTO;

public class main {

	public static void main(String[] args) throws Exception {

		Scanner scan = new Scanner(System.in); scan.useLocale(Locale.US);
		PessoaDTO pessoaDTO = new PessoaDTO();
		PessoaDAO pessoaDAO = new PessoaDAO();
		String nome;
		int idade;
		String genero;
		String telefone;
		String email;
		int op;
		boolean flag2 = true;
		boolean flag = true;

		do {
// inicio das  perguntas 
			
			System.out.println("selecione o que deseja fazer ");
			System.out.println("1- inquilinos");
			System.out.println("2- unidades");
			System.out.println("3- despesa das unidades");
			System.out.println("4- sair");

			op = scan.nextInt();

			switch (op) {
			case 1:

				do {
					System.out.println("Seja bem vindo ao sistema de cadastro");
					System.out.println("1-cadastrar novo inquilino ");
					System.out.println("2-verificar todos os inquilinos");
					System.out.println("3-remover ");
					System.out.println("4-Atualizar dados");
					System.out.println("5-sair");
					op = scan.nextInt();

					switch (op) {
					case 1:
						System.out.println("qual o nome?");
						nome = scan.next();
						System.out.println("qual a idade?");
						idade = scan.nextInt();
						System.out.println("qual o genero?");
						genero = scan.next();
						System.out.println("qual o telefone?");
						telefone = scan.next();
						System.out.println("qual o email?");
						email = scan.next();

						pessoaDTO.setNome(nome);
						pessoaDTO.setIdade(idade);
						pessoaDTO.setGenero(genero);
						pessoaDTO.setTelefone(telefone);
						pessoaDTO.setEmail(email);

						pessoaDAO.inserir(pessoaDTO);

						System.out.println("foi cadastrado");

						break;
					case 2:

						pessoaDAO.listarTodos();

						break;

					case 3:
						System.out.println("digite o id que deseja remover ");
						op = scan.nextInt();
						pessoaDAO.remover(op);
						break;

					case 4:
						int op2;
						System.out.println("digite o id que deseja alterar ");
						op = scan.nextInt();
						System.out.println(" o que vc quer alterar");
						System.out.println(" 1-nome");
						System.out.println("2-idade");
						System.out.println("3-genero");
						System.out.println("4-telefone");
						System.out.println("5-email");
						op2 = scan.nextInt();

						switch (op2) {
						case 1:
							String nome2;
							System.out.println("digite o nome");
							nome2 = scan.next();
							pessoaDTO.setId_pessoa(op);
							pessoaDTO.setNome(nome2);

							pessoaDAO.atualizarnome(pessoaDTO);
							break;

						default:
							break;
						case 2:
							int idade2;
							System.out.println("digite a idade");
							idade2 = scan.nextInt();
							pessoaDTO.setId_pessoa(op);
							pessoaDTO.setIdade(idade2);

							pessoaDAO.atualizaridade(pessoaDTO);
							break;

						case 3:
							String genero2;
							System.out.println("digite o genero");
							genero2 = scan.next();
							pessoaDTO.setId_pessoa(op);
							pessoaDTO.setGenero(genero2);

							pessoaDAO.atualizargenero(pessoaDTO);
							break;

						case 4:
							String telefone2;
							System.out.println("digite o telefone");
							telefone2 = scan.next();
							pessoaDTO.setId_pessoa(op);
							pessoaDTO.setTelefone(telefone2);

							pessoaDAO.atualizarTelefone(pessoaDTO);
							break;

						case 5:
							String email2;
							System.out.println("digite o email");
							email2 = scan.next();
							pessoaDTO.setId_pessoa(op);
							pessoaDTO.setEmail(email2);

							pessoaDAO.atualizaremail(pessoaDTO);
							break;

						}

						break;
					case 5:
						System.out.println("ate mais ;)");
						flag = false;
						break;

					}
				} while (flag);

				break;
			case 2:

				int numeroDaUnidade;
				String nomeDaUnidade;
				String propietario;
				String condominio;
				String endereco;

				do {
					System.out.println("Seja bem vindo ao sistema de cadastro");
					System.out.println("1-cadastrar nova unidade ");
					System.out.println("2-verificar todas as unidades");
					System.out.println("3-remover ");
					System.out.println("4-Atualizar dados");
					System.out.println("5-sair");
					op = scan.nextInt();

					switch (op) {
					case 1:
						System.out.println("qual o numero da unidade?");
						numeroDaUnidade = scan.nextInt();
						System.out.println("qual o nome dessa unidade ?");
						nomeDaUnidade = scan.next();
						System.out.println("qual o proprietaro?");
						propietario = scan.next();
						System.out.println("qual o condominio?");
						condominio = scan.next();
						System.out.println("qual o endereco?");
						endereco = scan.next();

						pessoaDTO.setNumeroDaUnidade(numeroDaUnidade);
						pessoaDTO.setNomeDaUnidade(nomeDaUnidade);
						pessoaDTO.setPropietario(propietario);
						pessoaDTO.setCondominio(condominio);
						pessoaDTO.setEndereco(endereco);

						pessoaDAO.inserirUnidade(pessoaDTO);

						break;
					case 2:

						pessoaDAO.listarTodasUnidades();

						break;

					case 3:
						System.out.println("digite o id que deseja remover ");
						op = scan.nextInt();
						pessoaDAO.removerUnidades(op);
						break;

					case 4:
						int op2;
						System.out.println("digite o id que deseja alterar ");
						op = scan.nextInt();
						System.out.println(" o que vc quer alterar");
						System.out.println(" 1-numeroDaUnidade");
						System.out.println("2-NomeDaUnidade");
						System.out.println("3-propietario");
						System.out.println("4-condominio");
						System.out.println("5-endereço");
						op2 = scan.nextInt();

						switch (op2) {
						case 1:
							int numeroDaUnidade2;
							System.out.println("digite o numero da unidade");
							numeroDaUnidade2 = scan.nextInt();
							pessoaDTO.setNumeroDaUnidade(op2);
							pessoaDTO.setNumeroDaUnidade(numeroDaUnidade2);

							pessoaDAO.atualizarNumeroDaUnidade(pessoaDTO);
							break;

						default:
							break;
						case 2:
							String nomeDaUnidade2;
							System.out.println("digite o nome da unidade");
							nomeDaUnidade2 = scan.next();
							pessoaDTO.setNumeroDaUnidade(op2);
							pessoaDTO.setNomeDaUnidade(nomeDaUnidade2);

							pessoaDAO.atualizaridade(pessoaDTO);
							break;

						case 3:
							String propietario2;
							System.out.println("digite o propietario");
							propietario2 = scan.next();
							pessoaDTO.setNumeroDaUnidade(op2);
							pessoaDTO.setCondominio(propietario2);

							pessoaDAO.atualizargenero(pessoaDTO);
							break;

						case 4:
							String condominio2;
							System.out.println("digite o condominio");
							condominio2 = scan.next();
							pessoaDTO.setId_pessoa(op2);
							pessoaDTO.setTelefone(condominio2);

							pessoaDAO.atualizarTelefone(pessoaDTO);
							break;

						case 5:
							String endereco2;
							System.out.println("digite o email");
							endereco2 = scan.next();
							pessoaDTO.setId_pessoa(2);
							pessoaDTO.setEmail(endereco2);

							pessoaDAO.atualizaremail(pessoaDTO);
							break;

						}

						break;
					case 5:
						System.out.println("ate mais ;)");
						flag = false;
						break;

					}
				} while (flag);

				break;
			case 3:
				String descricao;
				String tipo_despesa;
				String Status_pagamento;
				int vencimento_fatura;
				Double valor;
				int id_despesas;
				int op3;
				System.out.println(" selecione uma opção");
				System.out.println("1-inserir divida");
				System.out.println("2-verificar todas as dividas");
				System.out.println("3-visualizar as despesas");
				op3 = scan.nextInt();
				switch (op3) {
				case 1:
				
					
					System.out.println("descreva a despesa");
					descricao = scan.next();
					System.out.println("qual o tipo ?");
					tipo_despesa = scan.next();
					System.out.println("qual o status?");
					 Status_pagamento= scan.next();
					System.out.println("qual o valor?");
					valor = scan.nextDouble();
					System.out.println("qual o vencimento?");
					vencimento_fatura= scan.nextInt();
									
					pessoaDTO.setDescricao(descricao);
					pessoaDTO.setTipo_despesa(tipo_despesa);
					pessoaDTO.setStatus_pagamento(Status_pagamento);
					pessoaDTO.setValor(valor);
					pessoaDTO.setVencimento_fatura(vencimento_fatura);
					pessoaDAO.inserirDespesa(pessoaDTO);

					break;   
				case 2:
					pessoaDAO.listarTodasdispesas();
					break;
					
				case 3:
					pessoaDAO.carregaTabela();
					break;
					
				case 4:
					pessoaDAO.carregaTabelaVencido();
					
					break;
				default:
					
					break;
				}

				break;

			case 4:
				flag2 = false;
				break;
			default:
				break;
			}
		} while (flag2);

	}
}
