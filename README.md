# MVP Feira Modelo 🥬

Este repositório contém o código-fonte do Minimum Viable Product (MVP) desenvolvido para auxiliar feirantes na gestão de estoque e precificação, alinhado ao Objetivo de Desenvolvimento Sustentável (ODS) 12: Consumo e Produção Responsáveis, visando a redução do desperdício de alimentos.

## 📱 Sobre o Projeto

O aplicativo foi desenhado especificamente para o uso em ambientes de feira livre (alta incidência solar, mãos ocupadas e necessidade de agilidade). Ele permite que o feirante (Gabriel) atualize rapidamente a disponibilidade e os preços dos alimentos, bloqueando a exportação de tabelas incompletas e garantindo a precisão da informação repassada aos clientes.

## 🛠 Tecnologias e Arquitetura

* **Plataforma:** Android
* **Linguagem:** Java
* **Padrão Arquitetural:** MVC (Model-View-Controller)
* **Persistência de Dados:** SQLite utilizando a biblioteca **Room** (funcionamento 100% offline)
* **Interface:** XML com componentes de acessibilidade (alto contraste e botões de no mínimo 48dp)

## ⚙️ Funcionalidades Principais

* **Autenticação Segura:** Acesso protegido por PIN (RNF01).
* **Gestão de Inventário:** Atualização ágil de preço e quantidade disponível.
* **Validação de Dados:** Prevenção de campos monetários vazios para itens ativos (RNF02).
* **Feedback Multissensorial:** Alertas visuais e lógicos caso o feirante tente gerar a tabela com informações faltantes.

## 🚀 Instruções de Execução (Como rodar o projeto)

1. Certifique-se de ter o **Android Studio** instalado em sua máquina.
2. Faça o clone deste repositório:
```bash
git clone https://github.com/SEU-USUARIO/mvp-feira-modelo.git

```


3. Abra o Android Studio e selecione **File > Open**, navegando até a pasta clonada.
4. Aguarde o Android Studio realizar a sincronização dos arquivos e baixar as dependências do `build.gradle` (como o Room SQLite).
5. Conecte um dispositivo físico via cabo USB com o modo de depuração ativado, ou inicie um Emulador Android (AVD).
6. Clique no botão **Run (▶)** na barra de ferramentas superior para compilar e instalar o aplicativo.
