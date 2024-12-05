# Usar a imagem base do Maven com OpenJDK 17
FROM maven:3.8.3-openjdk-17

# Definir variáveis de ambiente para facilitar
ENV PROJECT_HOME /usr/src/av3poo
ENV JAR_NAME av3poo.jar

# Criar o diretório de destino e definir o diretório de trabalho
RUN mkdir -p $PROJECT_HOME
WORKDIR $PROJECT_HOME

# Copiar o código-fonte do projeto para o container
COPY . .

# Construir o projeto, pulando os testes
RUN mvn clean package -DskipTests

# Mover o arquivo JAR para o diretório de destino
RUN mv target/$JAR_NAME $PROJECT_HOME/

# Expor a porta para a aplicação
EXPOSE 8080

# Definir o comando de entrada para rodar a aplicação
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "av3poo.jar"]
