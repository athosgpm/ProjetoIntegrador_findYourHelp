# Documentação Back-End

## Sistema de Rede Social
**Sistema realizado por: Andressa Ferreira, Athos Mesquita, Carolina Guida, Gustavo Guilhen, Maria Nazaré, Osvaldo Velasco, Tatiane Antunes**
## Sobre
O projeto consiste em uma `Rede Social` voltada para o público de classe média-baixa onde podem expor suas ideias de empreendedorismo e pessoas que gostarem da ideia podem colaborar, seja de forma financeira quanto com serviços prestados.

## Tecnologias principais
- Spring Boot
- Spring Data
- Spring Web
- Spring Security
- Swagger

## Tema

 ### Model

| Atributo | Tipo | Qtd. Caracteres |
|----------|------|-----|
| idTema | [PK] long |
| categoriaTema | String | min = 5, max = 50
| postagem | List < Postagem > |

A tabela possuirá os atributos **ID** referente ao código de cada tema e **categoria** onde o usuário com o perfil `Empreendedor` poderá ser inserida a temática: tecnologia, meio ambiente, projetos, financiamento, etc. Mais a lista de postagem com a marcação @OneToMany.

### CRUD
 
| Métodos | End-points | Descrição |
|----------|--------------|----------|
| Get | /tema | Listar todos os temas existentes
| Get | /tema/{idTema} | Listar tema específico pelo ID
| Get | /tema/categoriaTema/{categoriaTema} | Listar um tema específico pela categoria
| Post | /tema | Inserir os dados
| Put | /tema | Editar algum dado específico
| Delete | /tema/{idTema} | Excluir algum dado pelo ID

A tabela possuirá os end-points básicos (get, post, put e delete) e mais dois métodos específicos, que buscam pelo id e pela categoria.

### JSON

#### Post tema

```json
{
    "categoriaTema": "Inovação"
}
```

#### Get tema

```json
[
    {
        "idTema": 1,
        "categoriaTema": "Inovação",
        "postagem": []
    }
]
```

## Postagem

 ### Model

| Atributo | Tipo | Qtd. Caracteres |
|----------|------|-----|
| idPostagem | [PK] long |
| tituloPostagem | String | min = 5, max = 50
| tipoAjudaPostagem | String | min = 1, max = 50
| urlImagemPostagem | String | min = 5, max = 255
| descricaoPostagem | String | min = 5, max = 255
| dataPostagem | Date |
| tema_id | [FK] long
| usuario_id | [FK] long
| comentario_id | [FK] long

A tabela possuirá os atributos **idPostagem**, **tituloPostagem**, **tipoAjudaPostagem**, **urlImagemPostagem**, **descriçãoPostagem** e **dataPostagem**, referente a cada postagem, mais as listas **tema** com a marcação @ManyToOne, **usuario** com a marcação @ManyToOne e o **comentario** com a marcação @OneToMany onde irão fazer o link com esse.

### CRUD
 
| Métodos | End-points | Descrição |
|----------|--------------|----------|
| Get | /postagens | Listar todas as postagens existentes
| Get | /postagens/{idPostagem} | Listar postagem específica pelo ID
| Get | /postagens/tituloPostagem/{tituloPostagem} | Listar uma postagem específica pelo Título
| Post | /postagens | Inserir os dados
| Put | /postagens | Editar algum dado específico
| Delete | /postagens/{idPostagem} | Excluir algum dado pelo ID

A tabela possuirá os end-points básicos (get, post, put e delete) e mais dois métodos específicos, que buscam pelo id e pelo título.

### JSON

#### Post postagens

```json
{
    "tituloPostagem": "Exemplo",
    "tipoAjudaPostagem": "Financeira",
    "urlImagemPostagem": "https://i.imgur.com/rc9U7wD.png",
    "descricaoPostagem": "Exemplo de descrição para a postagem."
}
```

#### Get postagens 

```json
[
    {
        "idPostagem": 1,
        "tituloPostagem": "Exemplo",
        "tipoAjudaPostagem": "Financeira",
        "urlImagemPostagem": "https://i.imgur.com/rc9U7wD.png",
        "descricaoPostagem": "Exemplo de descrição para a postagem.",
        "dataPostagem": "2021-04-19T00:00:46.174+00:00",
        "tema": null,
        "usuario": null,
        "comentario": []
    }
]
```

## ComentarioPostagem

 ### Model

| Atributo | Tipo | Qtd. Caracteres |
|----------|------|-----|
| idComentario | [PK] long |
| comentario | String | min = 0, max = 9999
| dataComentario | Date
| usuario_id | [FK] long
| postagem_id | [FK] long

A tabela possuirá os atributos **idComentario**, **comentario** e **dataComentario** referente a cada comentário, mais as listas **usuario** com a marcação @ManyToOne e a **postagem** com a marcação @ManyToOne onde irão fazer o link com esse.

### CRUD
 
| Métodos | End-points | Descrição |
|----------|--------------|----------|
| Get | /comentarios| Listar todos os comentários existentes
| Get | /comentarios/{id} | Listar comentário específico pelo ID
| Post | /comentarios | Inserir os dados
| Put | /comentarios | Editar algum dado específico
| Delete | /comentarios/{id} | Excluir algum dado pelo ID

A tabela possuirá os end-points básicos (get, post, put e delete) e mais um método específico, que busca pelo id.

### JSON

#### Post comentarios

```json
{
    "comentario": "Exemplo de comentário para uma postagem."
}
```

#### Get comentarios

```json
[
    {
        "idComentario": 1,
        "comentario": "Exemplo de comentário para uma postagem.",
        "dataComentario": "2021-04-19T00:04:02.978+00:00",
        "usuario": null,
        "postagem": null
    }
]
```

## Usuário

 ### Model

| Atributo | Tipo | Qtd. Caracteres |
|----------|------|-----------------|
| idUsuario | [PK] long 
| nomeUsuario | String | min = 2, max = 12
| emailUsuario | String | min = 5, max = 100
| senhaUsuario | String |  min = 2, max = 100
| imagemUsuario | String |
| tipoUsuario | String |
| telefoneUsuario | String |
| postagem_id | [FK] long
| comentario_id | [FK] long

A tabela possuirá os atributos **ID** referente ao código de cada usuário, **nomeUsuario**, **emailUsuario**, **senhaUsuario**, **imagemUsuario**, **tipoUsuario** e **telefoneUsuario**. Mais as listas **postagem** com marcação @OneToMany e **comentario** com marcação @OneToMany, onde irão fazer o link com esse.

### CRUD
 
| Métodos | End-points | Descrição |
|----------|--------------|----------|
| Get | /usuario | Listar todos os usuários existentes
| Get | /usuario/{id} | Listar usuário específico pelo ID
| Post | /usuario/cadastrar | Cadastrar um novo usuário
| Post | /usuario/logar | Logar um usuário existente
| Put | /usuario | Editar algum dado específico

### Model UserLogin (apenas para Login)
| Atributo | Tipo | 
|----------|------|
| nomeUsuario | String |
| emailUsuario | String | 
| senhaUsuario | String |  
| imagemUsuario | String |
| tipoUsuario | String |
| telefoneUsuario | String |
| token | String |

Criada a model ```UserLogin```, que devolve os dados do usuário logado com o token de autenticação.

Criada a ```UsuarioRepository``` com busca específica para determinado usuário.

Criada a package ```Security``` com as classes ```BasicSecurityConfig```, ```UserDetailsImpl``` e ```UserDetailsServiceImpl```, aplicando as regras de negócio que foram determinadas na interface e restringindo a interação sem autenticação para os caminhos ```"/usuario/cadastrar"``` e ```"/usuario/logar"```.

Criada a package ```Service``` com a classe ```UsuarioService``` que encripta a senha escolhida pelo usuário e guarda no banco de dados.


### JSON

#### Post cadastrar

```json
{
    "nomeUsuario": "Exemple",
    "emailUsuario": "exemple@gmail.com",
    "senhaUsuario": "123456",
    "tipoUsuario": "Empreendedor",
    "telefoneUsuario": "00123451234"
}
```

#### Post logar

```json
{
    "emailUsuario": "exemple@gmail.com",
    "senhaUsuario": "123456"
}
``` 

