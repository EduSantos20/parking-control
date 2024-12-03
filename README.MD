# Sistema de Controle de Estacionamento de Shopping (PARKING-CONTROL)

## 📝 Descrição do Projeto
Este projeto consiste em uma aplicação para gerenciamento de estacionamento de shopping, permitindo controle de entrada, saída, registro de veículos e cálculo de tempo de permanência.

## 🚀 Pré-requisitos
Antes de começar, verifique se você atende aos seguintes requisitos:

### Tecnologias
- Java (versão 21 ou superior)
- Spring Boot
- Maven
- Banco de Dados (PostgreSQL/MySQL)
- Docker (opcional, para conteinerização) na minha aplicação não foi feito docker

### Dependências
- Spring Web
- Spring Data JPA
- Validation
- Swagger (para documentação de API)
- PostgreSQL Driver

## 🔧 Instalação

### Clonar o Repositório
```bash
git clone https://github.seu-usuario/controle-estacionamento.git
cd parking-control
```

### Configuração do Ambiente
1. Instale o JDK 21 ou superior
2. Instale Maven ou Gradle
3. Configure as variáveis de ambiente do banco de dados no `application.properties`

### Configuração do Banco de Dados
- Crie um banco de dados PostgreSQL ou MySQL
- Configure as credenciais no arquivo `application.properties`
```Exemplo
  spring.application.name=parking-control
  spring.datasource.url=jdbc:postgresql://localhost:5433/parking-control
  spring.datasource.username=postgres
  spring.datasource.password=1234

  ## gera as tabelas assim que iniciar a aplicação
  spring.jpa.hibernate.ddl-auto=update 

  spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
```

### Variáveis de Ambiente
Crie um arquivo `.env` com as seguintes variáveis:
```
DB_HOST=localhost
DB_PORT=5432
DB_NAME=estacionamento
DB_USER=usuario
DB_PASS=senha
```

## 🚦 Como Rodar a Aplicação

### Modo de Desenvolvimento
```bash
# Com Maven
./mvnw spring-boot:run

# Com Gradle
./gradlew bootRun
```

### Modo de Produção
```bash
# Gerar JAR
./mvnw clean package

# Executar JAR
java -jar target/parking-control.jar
```

### Utilizando Docker
```bash
# Construir imagem
docker build -t parking-control .

# Rodar container
docker run -p 8080:8080 parking-control
```

## 🧪 Testes
```bash
# Executar testes unitários
./mvnw test

# Executar testes de integração
./mvnw verify
```

## 📦 Principais Funcionalidades
- Registro de entrada de veículos
- Registro de saída de veículos
- Cálculo de tempo de permanência
- Geração de comprovante
- Controle de vagas disponíveis

## 🤝 Contribuição
1. Faça um fork do projeto
2. Crie uma branch (`git checkout -b feature/nova-funcionalidade`)
3. Commit suas alterações (`git commit -m 'Adicionar nova funcionalidade'`)
4. Push para a branch (`git push origin feature/nova-funcionalidade`)
5. Abra um Pull Request

## 📜 Licença
Este projeto está sob a licença MIT - veja o arquivo [LICENSE.md](LICENSE.md) para detalhes.

## 📞 Contato
Seu Nome - eduardosantosgt18@gmail.com

## 🚨 Avisos Importantes
- Sempre use variáveis de ambiente para configurações sensíveis
- Mantenha suas dependências atualizadas
- Siga as boas práticas de segurança
```