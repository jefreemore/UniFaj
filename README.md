# GitHub
1. git init
	Responsável por criar uma subpasta oculta chamada ".git" dentro do seu diretório atual.
	A mesma contem todos os arquivos necessários para o Git rastrear as mudanças no seu projeto.
2. git add README.md
	Responsável por adicionar arquivos ao github.
	Por exemplo: Um arquivo específico "README.md" ou todos os aquivos com "."
3. git commit -m "Primeiro commit do meu projeto"
	Responsável por descrever o que foi alterado(Protocolo de segurança e acompanhamento).
4. git remote add origin [URL_DO_SEU_REPOSITORIO_REMOTO]
	Responsável por acessar repositórios remotomente.
5. git push -u origin master | git push -u origin main
	Responsável por enviar seus(push) commits para o repositório remoto.

## Resumo dos comandos mais importantes:
- **git init:** Inicializa um novo repositório Git local.
- **git add .:** Adiciona todos os arquivos do diretório atual à staging area.
- **git commit -m "Mensagem":** Salva as mudanças na história do repositório.
- **git remote add origin [URL]:** Conecta seu repositório local a um repositório remoto.
- **git push -u origin [nome_da_branch]:** Envia seus commits locais para o repositório remoto.

## Command --help:
 git [-v | --version] [-h | --help] [-C <path>] [-c <name>=<value>]
           [--exec-path[=<path>]] [--html-path] [--man-path] [--info-path]
           [-p | --paginate | -P | --no-pager] [--no-replace-objects] [--no-lazy-fetch]
           [--no-optional-locks] [--no-advice] [--bare] [--git-dir=<path>]
           [--work-tree=<path>] [--namespace=<name>] [--config-env=<name>=<envvar>]
           <command> [<args>]

These are common Git commands used in various situations:

start a working area (see also: git help tutorial)
   clone      Clone a repository into a new directory
   init       Create an empty Git repository or reinitialize an existing one

work on the current change (see also: git help everyday)
   add        Add file contents to the index
   mv         Move or rename a file, a directory, or a symlink
   restore    Restore working tree files
   rm         Remove files from the working tree and from the index

examine the history and state (see also: git help revisions)
   bisect     Use binary search to find the commit that introduced a bug
   diff       Show changes between commits, commit and working tree, etc
   grep       Print lines matching a pattern
   log        Show commit logs
   show       Show various types of objects
   status     Show the working tree status

grow, mark and tweak your common history
   backfill   Download missing objects in a partial clone
   branch     List, create, or delete branches
   commit     Record changes to the repository
   merge      Join two or more development histories together
   rebase     Reapply commits on top of another base tip
   reset      Reset current HEAD to the specified state
   switch     Switch branches
   tag        Create, list, delete or verify a tag object signed with GPG

collaborate (see also: git help workflows)
   fetch      Download objects and refs from another repository
   pull       Fetch from and integrate with another repository or a local branch
   push       Update remote refs along with associated objects