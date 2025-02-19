package Main;

import java.util.*;
import Itens.*;
import Usuarios.*;

public class Sistema {

	private ClasseControle controle;

	public Sistema() {
		controle = new ClasseControle();
	}

	public void menu() {//menu
		Scanner sc = new Scanner(System.in);
		int op = 1;

		while (op != 0) {//le as opções enquanto o valor digitado for diferente de 0
			System.out.print("Escolha uma opção:\n1. Modo Administrador\n2. Modo Atendimento\n0. Sair\nR: ");
			op = sc.nextInt();

			switch (op) {
			case 1:
				this.modoAdministrador(sc);
				break;

			case 2:
				this.modoAtendimento();
				break;

			case 0:
				sc.close();
				return;

			default:
				System.out.println("Opção inválida");
			}
		}
	}
	
	private void mostraItens() {
		System.out.println("Livros e Periódicos: ");
		for (Livro l : this.controle.getLivros()) {
			System.out.println(l.toString());
		}
		System.out.println("Mapas Tematicos:");
			for (MapaTematico p : this.controle.getMapas()) {
				System.out.println(p.toString());
			}
		}

	private void modoAtendimento() {
		int n = 0;
		do {
		System.out.println("Selecione um modo de atendimento:");
		System.out.println("1. Usuario Externo");
		System.out.println("2. Aluno");
		System.out.println("3. Professor");
		
		int op = new Scanner(System.in).nextInt();
		switch (op) {
		case 1:
			n = 1;
			this.modoAtendimentoUsuario(new Scanner(System.in));
			break;
		case 2:
			n = 1;
			this.modoAtendimentoAluno(new Scanner(System.in));
			break;
		case 3:
			n = 1;
			this.modoAtendimentoProfessor(new Scanner(System.in));
			
			break;
		default:
			System.out.println("Digite uma opção valida");
			break;

		}
		} while (n == 0);
	}

	private void modoAdministrador(Scanner scanner) {
		while (true) {
			System.out.println("Modo Administrador:");
			System.out.println("1. Adicionar Livro");
			System.out.println("2. Adicionar Mapa");
			System.out.println("3. Listar Itens");
			System.out.println("0. Voltar");
			int opcao = scanner.nextInt();
			scanner.nextLine();

			switch (opcao) {
			case 0:
				return;
			case 1:
				System.out.print("Digite o título do livro: ");
				String tituloLivro = scanner.nextLine();
				this.controle.adicionarLivro(new Livro(tituloLivro));
				break;
			case 2:
				System.out.print("Digite o título do mapa: ");
				String tituloMapa = scanner.nextLine();
				System.out.print("Digite o privilegio do mapa (1: Usuario; 2: Aluno; 3: Professor): ");
				int privMapa = new Scanner(System.in).nextInt();
				this.controle.adicionarMapaTematico(new MapaTematico(tituloMapa, privMapa));
				break;
			case 3:
				this.mostraItens();
				break;
			default:
				System.out.println("Opção inválida. Tente novamente.");
			}
		}

	}

	private void modoAtendimentoUsuario(Scanner scanner) {
		while (true) {
			System.out.println("Modo Atendimento:");
			System.out.println("1. Listar Itens");
			System.out.println("2. Retirar Livro");
			System.out.println("3. Retirar Mapa");
			System.out.println("4. Devolver livro");
			System.out.println("5. Devolver mapa");
			System.out.println("0. Voltar");
			int opcao = scanner.nextInt();
			scanner.nextLine(); 
			switch (opcao) {
			case 0:
				return;
			case 1:
				this.mostraItens();
				break;
			case 2:
				System.out.print(" título do livro: ");
				String titulo = scanner.nextLine();
				System.out.print("nome do usuario: ");
				String nomeUsuario = scanner.nextLine();
				this.controle.adicionarUsuarioExt(new Usuario(nomeUsuario));
				this.controle.emprestarLivro(titulo, this.controle.getUsuario(nomeUsuario));
				break;
			case 3:
				System.out.print(" título do mapa: ");
				String tMapa = scanner.nextLine();
				System.out.print("nome do usuario: ");
				String nomeUser = scanner.nextLine();
				this.controle.adicionarUsuarioExt(new Usuario(nomeUser));
				this.controle.emprestarMapa(tMapa, this.controle.getUsuario(nomeUser));
				break;
			 case 4:
           	  System.out.print(" título do livro: ");  
                 String title = scanner.nextLine();  
                 System.out.print("nome do usuario: ");  
                 String nomeUsr = scanner.nextLine();
                 if(nomeUsr.equals(this.controle.getLivro(title).getDono().getNome())) {
               	  this.controle.devolverLivro(title, this.controle.getUsuario(nomeUsr));
                 }
           	  break;
			 case 5:
				 System.out.print("título do mapa: ");  
                 String nome = scanner.nextLine();  
                 System.out.print(" nome do usuario: ");  
                 String nomeUs = scanner.nextLine();
                 if(nomeUs.equals(this.controle.getMapaTematico(nome).getDono().getNome())) {
               	  this.controle.devolverMapaTematico(nome, this.controle.getUsuario(nomeUs));
                 }
           	  break;
           	  
			default:
				System.out.println("Opção inválida. Tente novamente.");
			}
		}
	}

	private void modoAtendimentoAluno(Scanner scanner) {
			  
	          System.out.println("Modo Atendimento:");  
	          System.out.println("1. Listar Itens");  
	          System.out.println("2. Retirar Livro");
	          System.out.println("3. Retirar Mapa");
	          System.out.println("4. Devolver Livro");
	          System.out.println("5. Devolver Mapa");
	          System.out.println("0. Voltar");  
	          int opcao = scanner.nextInt();
	          Date d = new Date();
	          scanner.nextLine(); 
	          switch (opcao) {  
	              case 0:  
	                  return;  
	              case 1:  
	                  this.mostraItens();
	                  break;  
	              case 2:  
	                  System.out.print(" título do livro: ");  
	                  String titulo = scanner.nextLine();  
	                  System.out.print(" nome do usuario: ");  
	                  String nomeUsuario = scanner.nextLine();
	                  
	                  this.controle.adicionarAluno(new UsuarioAluno(nomeUsuario, d));
	                  this.controle.emprestarLivro(titulo, this.controle.getUsuario(nomeUsuario));  
	                  break;
	              case 3:
	            	  System.out.print("título do mapa: ");  
	                  String tMapa = scanner.nextLine();  
	                  System.out.print("nome do usuario: ");  
	                  String nomeUser = scanner.nextLine();  
	                  this.controle.adicionarAluno(new UsuarioAluno(nomeUser, d));
	                  this.controle.emprestarMapa(tMapa, this.controle.getUsuario(nomeUser));  
	                  break;
	              case 4:
	            	  System.out.print(" título do livro: ");  
	                  String title = scanner.nextLine();  
	                  System.out.print("nome do usuario: ");  
	                  String nomeUsr = scanner.nextLine();
	                  if(nomeUsr.equals(this.controle.getLivro(title).getDono().getNome())) {
	                	  this.controle.devolverLivro(title, this.controle.getUsuario(nomeUsr));
	                  }
	            	  break;
	            
	              case 5:
	            	  System.out.print(" título do mapa: ");  
	            	  String nome = scanner.nextLine();  
	                     System.out.print("nome do usuario: ");  
	                     String nomeU = scanner.nextLine();
	                     if(nomeU.equals(this.controle.getMapaTematico(nome).getDono().getNome())) {
	                   	  this.controle.devolverMapaTematico(nome, this.controle.getUsuario(nomeU));
	                     }
	             	  break;
	              default:  
	                  System.out.println("Opção inválida. Tente novamente.");
	          }  
	      }

	private void modoAtendimentoProfessor(Scanner scanner) {
		while (true) {
			System.out.println("Modo Atendimento:");
			System.out.println("1. Listar Itens");
			System.out.println("2. Retirar Livro");
			System.out.println("3. Retirar Mapa");
			System.out.println("4. Retirar Periodico");
			System.out.println("5. Bloquear Livro");
			System.out.println("6. Desbloquear Livro");
			System.out.println("7. Devolver livro");
			System.out.println("8. Devolver mapa");
			System.out.println("0. Voltar");
			int opcao = scanner.nextInt();
			scanner.nextLine(); 
			switch (opcao) {
			case 0:
				return;
			case 1:
				this.mostraItens();
				break;
			case 2:
				System.out.print(" título do item: ");
				String titulo = scanner.nextLine();
				System.out.print("nome do usuario: ");
				String nomeUsuario = scanner.nextLine();
				this.controle.adicionarProfessor(new UsuarioProfessor(nomeUsuario));
				this.controle.emprestarLivro(titulo, this.controle.getUsuario(nomeUsuario));
				break;
			case 3:
				System.out.print(" título do mapa: ");
				String tMapa = scanner.nextLine();
				System.out.print("nome do usuario: ");
				String nomeUser = scanner.nextLine();
				this.controle.adicionarProfessor(new UsuarioProfessor(nomeUser));
				this.controle.emprestarMapa(tMapa, this.controle.getUsuario(nomeUser));
				break;
			case 4:
				System.out.print(" título do periodico: ");
				String tPer = scanner.nextLine();
				System.out.print("nome do usuario: ");
				String nomeUsr = scanner.nextLine();
				this.controle.adicionarProfessor(new UsuarioProfessor(nomeUsr));
				this.controle.emprestarPer(tPer, this.controle.getProfessor(nomeUsr));
				break;
			case 5:
				System.out.print(" título do livro a ser bloqueado: ");
				String tLiv = scanner.nextLine();
				System.out.print("nome do usuario: ");
				String nomeU = scanner.nextLine();
				System.out.println("Digite um prazo para o desbloqueio do livro(em dias): ");
				int prazo = new Scanner(System.in).nextInt();
				this.controle.adicionarProfessor(new UsuarioProfessor(nomeU));
				this.controle.bloqueiaLivro(this.controle.getProfessor(nomeU), tLiv, prazo);
				break;
			case 6:
				System.out.print("Digite o título do livro a ser desbloqueado: ");
				String tLv = scanner.nextLine();
				System.out.print("nome do usuario: ");
				String nameU = scanner.nextLine();
				if(this.controle.getProfessor(nameU) != null) {
					if(nameU.equals(this.controle.getLivro(tLv).getBloqueador().getNome())) {
						this.controle.desbloqueiaLivro(this.controle.getProfessor(nameU), tLv);
					} else {
						System.out.println("Nome inválido");
					}
				} else {
					System.out.println("professor nao registrado");
				}
				
				
				break;
			case 7:
          	  System.out.print(" título do livro: ");  
                String title = scanner.nextLine();  
                System.out.print(" nome do usuario: ");  
                String nomeUsur = scanner.nextLine();
                if(nomeUsur.equals(this.controle.getLivro(title).getDono().getNome())) {
              	  this.controle.devolverLivro(title, this.controle.getUsuario(nomeUsur));
                }
          	  break;
            case 8:
             	  System.out.print(" título do mapa: ");  
                   String nome = scanner.nextLine();  
                   System.out.print("nome do usuario: ");  
                   String nomeUs = scanner.nextLine();
                   if(nomeUs.equals(this.controle.getMapaTematico(nome).getDono().getNome())) {
                 	  this.controle.devolverMapaTematico(nome, this.controle.getUsuario(nomeUs));
                   }
             	  break;
            case 9:
            	  System.out.print(" título do periodico: ");  
                  String name = scanner.nextLine();  
                  System.out.print("nome do usuario: ");  
                  String nomeUr = scanner.nextLine();
                  if(nomeUr.equals(this.controle.getLivro(name).getDono().getNome())) {
                	  this.controle.devolverLivro(name, this.controle.getUsuario(nomeUr));
                  }
            	  break;
				
			default:
				System.out.println("Opção inválida. Tente novamente.");
			}
		}

	}
}