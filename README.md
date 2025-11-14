# 📌 Projeto – Análise de Caixa Branca

## 📁 Arquivos incluídos
- src/login/UserOriginal.java – Código original fornecido
- src/login/UserFixed.java – Versão corrigida e comentada
- src/login/TestLogin.java – Classe de teste
- Analise_Codigo.xlsx – Planilha de análise estática
- README.md

## 🧪 Análise do Código (Caixa Branca Estática)

### O código foi devidamente documentado?
Não. O código original praticamente não possui comentários explicativos.

### As variáveis e constantes possuem nomenclatura adequada?
Parcialmente. Algumas variáveis são claras, porém outras são genéricas (`result`, `nome`).

### Existem legibilidade e organização no código?
Parcial. A indentação está aceitável, mas o código carece de estrutura, comentários e boa organização.

### Todos os NullPointers foram tratados?
Não. O código pode gerar `NullPointerException`, especialmente ao criar `Statement` ou ao acessar o `ResultSet`.

### As conexões utilizadas foram fechadas?
Não. `Connection`, `Statement` e `ResultSet` não são fechados no código original, causando vazamento de recursos.

## 📊 Resumo da Planilha de Teste

| Item | Situação | Observação |
|------|----------|------------|
| Documentação | Não | Falta comentários |
| Nomenclatura | Parcial | Algumas variáveis genéricas |
| Legibilidade | Parcial | Estrutura pobre |
| NullPointer tratado | Não | Risco de exceções |
| Fechamento de conexões | Não | Nada é fechado |
| SQL seguro | Não | Vulnerável a SQL Injection |
| Exceções | Não | Tratamento genérico e fraco |

## 🔁 Notação de Grafo de Fluxo

### Nós (N): 10
1. Início
2. Conexão com o banco
3. Montagem do SQL
4. Bloco try
5. Execução da query
6. Verificação if (rs.next())
7. Caminho TRUE (usuário encontrado)
8. Caminho FALSE
9. Bloco catch
10. Retorno

### Arestas (E): 11
1→2  
2→3  
3→4  
4→5  
5→6  
6→7  
6→8  
7→10  
8→10  
4→9  
9→10  

## 📈 Complexidade Ciclomática
```
V(G) = E – N + 2
V(G) = 11 – 10 + 2 = 3
```

## 🛣️ Caminhos Básicos

### Caminho 1 — IF TRUE
1 → 2 → 3 → 4 → 5 → 6 → 7 → 10

### Caminho 2 — IF FALSE
1 → 2 → 3 → 4 → 5 → 6 → 8 → 10

### Caminho 3 — Exceção
1 → 2 → 3 → 4 → 9 → 10

## ✔️ Instruções para Entrega
- Subir o repositório completo no GitHub
- Deixar público
- Incluir este README completo
- Incluir a planilha .xlsx
- Garantir que o código está comentado e funcional
