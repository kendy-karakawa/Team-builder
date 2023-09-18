# Team-builder

## Sobre :memo:

O Team Builder é um aplicativo projetado para organizar equipes de maneira eficiente. Com ele, você pode inserir jogadores um por um e o aplicativo, automaticamente, distribui os jogadores em equipes com base na primeira letra do sobrenome de cada um.

</br>

## :robot: Tecnologias Utilizadas

- Java
- Springboot
- Angular 
- TypeScript
- Tailwind CSS
- H2

## :gear: Como rodar o projeto

```bash
# Clone este repositorio
$ git clone git@github.com:kendy-karakawa/Team-builder.git
# Acesse a pasta Team-builder
$ cd Team-builder
```

### Front-end
```bash
# Acesse a pasta front-end
$ cd fron-end
# Instale as dependencias
$ npm install
# Configure o arquivo environment.ts e environment.developnebt.ts que esta em src/environments
$ Altere o URL da API para a URL do back-end (http://localhost:port)
# Rode o front-end 
$ npm start
```
### Back-end
```bash
# Acesse a pasta criarTime
$ cd criarTime
# Acesse o arquivo PlayerController.java em  src/manin/java/br/com/criarTime/controller.
$ Altere a URL do CrossOrigin na linha 16 para a url do seu front (http://localhost:port)
# Acesse o arquivo TeamController.java em  src/manin/java/br/com/criarTime/controller.
$ Altere a URL do CrossOrigin na linha 16 para a url do seu front (http://localhost:port)
# Rode o Back-end
```

### Back-end com docker
```bash
# Acesse a pasta criarTime
$ cd criarTime
# Cria a imagem 
$ docker build -t criar-time .
# Rode a imagem criada 
$ docker run -p 8080:8080 criar-time -d
# dessa forma o Back ira rodar em http://localhost:8000
```

## :eyes: [Deploy](https://team-builder-web.vercel.app/)
