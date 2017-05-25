package jxta;

import java.io.File;
import java.io.FilenameFilter;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import net.jxta.share.ContentAdvertisement;

public final class Principal extends javax.swing.JFrame {

    static String Caminho = null;
    static String CheckSumOriginal = "desconhecido";
    static String NomeMeuArquivo = null;
    static IniciarJXTA Conexao = null;
    static ListaDePeers ListaPeers = null;
    static GrupoCompartilhamento IniciarCompartilhamento = null;
    static PesquisarArquivo IniciarPesquisa = null;
    static DownloadArquivo Download = null;
    static CalculoCheckSum MeuCheckSum = new CalculoCheckSum();
    static ContentAdvertisement[] ConteudoCompartilhado = null;

    public Principal() {
        initComponents();
        InicializarInterface();
    }

    public void InicializarInterface() {
        try {
            setResizable(false);
            setLocationRelativeTo(null);
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao iniciar a aplicação: " + ex.getMessage(), "J'Books", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TermosDeUso = new javax.swing.JDialog();
        jLabelImgLogo = new javax.swing.JLabel();
        jScrollPaneTermos = new javax.swing.JScrollPane();
        jTextAreaTermos = new javax.swing.JTextArea();
        btnAceitarTermo = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTabbedPane = new javax.swing.JTabbedPane();
        jPanelArquivosCompartilhados = new javax.swing.JPanel();
        txtNomeArquivo = new javax.swing.JTextField();
        btnPesquisarArquivo = new javax.swing.JButton();
        btnPararPesquisa = new javax.swing.JButton();
        btnDownload = new javax.swing.JButton();
        jScrollPaneArquivosCompartilhados = new javax.swing.JScrollPane();
        JTableArquivosCompartilhados = new javax.swing.JTable();
        jPanelSatusDownload = new javax.swing.JPanel();
        jLabelNomeArquivo = new javax.swing.JLabel();
        jLabelStatus = new javax.swing.JLabel();
        jLabelProgresso = new javax.swing.JLabel();
        lblNomeArquivo = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        minhaBarraDeProgresso = new javax.swing.JProgressBar();
        btnVerificarDownload = new javax.swing.JButton();
        btnCancelarDownload = new javax.swing.JButton();
        jPanelMeusArquivos = new javax.swing.JPanel();
        jScrollPaneMeusArquivos = new javax.swing.JScrollPane();
        meusArquivosCompartilhados = new javax.swing.JTable();
        btnAtualizarMeusArquivos = new javax.swing.JButton();
        jPanelPeers = new javax.swing.JPanel();
        jScrollPanePeers = new javax.swing.JScrollPane();
        ListaDePeers = new javax.swing.JList();
        btnPesquisarPeers = new javax.swing.JButton();
        btnPararPesquisaPeers = new javax.swing.JButton();
        btnConectar = new javax.swing.JButton();
        btnDesconectar = new javax.swing.JButton();
        jPanelSobre = new javax.swing.JPanel();
        jLabelSobre = new javax.swing.JLabel();
        jLabelImgLogo1 = new javax.swing.JLabel();
        jLabelDesenvolvedores = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        TermosDeUso.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        TermosDeUso.setTitle("Termos de uso - J'Books");
        TermosDeUso.setMinimumSize(new java.awt.Dimension(768, 514));
        TermosDeUso.setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        TermosDeUso.setResizable(false);

        jLabelImgLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImgLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jxta/icons/fundo-jbooks.png"))); // NOI18N

        jTextAreaTermos.setEditable(false);
        jTextAreaTermos.setColumns(1);
        jTextAreaTermos.setRows(5);
        jTextAreaTermos.setTabSize(1);
        jTextAreaTermos.setText("VINCULAÇÃO\n1 – O usuário ficará legalmente vinculado aos presentes termos de uso ao clicar na opção\nACEITAR.\n\nLICENÇA DE USO\n2 – Em decorrência da aceitação dos presentes Termos de Uso, o J’BOOKS concede  ao usuário\no direito de uso GRATUTO, NÃO EXCLUSIVO, NÃO COMERCIAL para acesso download e \ncompartilhamento de e-books no sistema.\n3 – A licença de uso é concedida por prazo INDETERMINADO, podendo ser revogado pela \nequipe de desenvolvimento a qualquer momento, independente de aviso prévio  ao Usuário.\n4 – Através da utilização do J’BOOKS licenciado a título GRATUITO, o Usuário poderá \nacessar os livros digitais e realizar o download e compartilhamento de novos arquivos.\n\nDIREITOS DE PROPRIEDADE INTELECTUAL\n5 – No caso de qualquer violação de direitos de propriedade intelectual, configura-se à\neventual violação, sujeitando o USUÁRIO às sanções previstas na legislação aplicável,\nem especial o pagamento de indenização pela violação de direitos autorais.\n\nDISPOSIÇÕES GERAIS\n6 – Todas as senhas de acesso fornecidas ao USUÁRIO, ou por ele implantadas, são  \npessoais e intrasferíveis, de uso exclusivo do USUÁRIO, que assume integral\nresponsabilidade pela sua guarda e sigilo, bem como pelo uso indevido por terceiros."); // NOI18N
        jScrollPaneTermos.setViewportView(jTextAreaTermos);

        btnAceitarTermo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jxta/icons/icon-aceitar-termos.png"))); // NOI18N
        btnAceitarTermo.setText("Aceito");
        btnAceitarTermo.setToolTipText("Aceito os termos e condições de uso da aplicação");
        btnAceitarTermo.setMaximumSize(new java.awt.Dimension(110, 23));
        btnAceitarTermo.setMinimumSize(new java.awt.Dimension(110, 23));
        btnAceitarTermo.setPreferredSize(new java.awt.Dimension(110, 23));
        btnAceitarTermo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceitarTermoActionPerformed(evt);
            }
        });

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jxta/icons/icon-cancelar.png"))); // NOI18N
        btnSair.setText("Não Aceito");
        btnSair.setMaximumSize(new java.awt.Dimension(110, 23));
        btnSair.setMinimumSize(new java.awt.Dimension(110, 23));
        btnSair.setPreferredSize(new java.awt.Dimension(110, 23));
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("TERMOS DE USO");

        javax.swing.GroupLayout TermosDeUsoLayout = new javax.swing.GroupLayout(TermosDeUso.getContentPane());
        TermosDeUso.getContentPane().setLayout(TermosDeUsoLayout);
        TermosDeUsoLayout.setHorizontalGroup(
            TermosDeUsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TermosDeUsoLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(TermosDeUsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TermosDeUsoLayout.createSequentialGroup()
                        .addComponent(btnAceitarTermo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TermosDeUsoLayout.createSequentialGroup()
                        .addGroup(TermosDeUsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPaneTermos)
                            .addComponent(jLabelImgLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20))))
        );
        TermosDeUsoLayout.setVerticalGroup(
            TermosDeUsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TermosDeUsoLayout.createSequentialGroup()
                .addComponent(jLabelImgLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(4, 4, 4)
                .addComponent(jScrollPaneTermos, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TermosDeUsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceitarTermo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("J'Books");
        setResizable(false);

        jPanelArquivosCompartilhados.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisar arquivos"));
        jPanelArquivosCompartilhados.setToolTipText("");

        txtNomeArquivo.setToolTipText("Informe o nome do arquivo");

        btnPesquisarArquivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jxta/icons/icon-pesquisar-jbooks.png"))); // NOI18N
        btnPesquisarArquivo.setText("Pesquisar");
        btnPesquisarArquivo.setToolTipText("Pesquisar arquivo compartilhado");
        btnPesquisarArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarArquivoActionPerformed(evt);
            }
        });

        btnPararPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jxta/icons/icon-parar.png"))); // NOI18N
        btnPararPesquisa.setText("Parar");
        btnPararPesquisa.setToolTipText("Parar pesquisa");
        btnPararPesquisa.setEnabled(false);
        btnPararPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPararPesquisaActionPerformed(evt);
            }
        });

        btnDownload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jxta/icons/icon-downloads.png"))); // NOI18N
        btnDownload.setText("Download");
        btnDownload.setToolTipText("Download do arquivo selecionado");
        btnDownload.setEnabled(false);
        btnDownload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownloadActionPerformed(evt);
            }
        });

        JTableArquivosCompartilhados.setAutoCreateRowSorter(true);
        JTableArquivosCompartilhados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nome do Arquivo", "Tamanho (Bytes)", "Check Sum (CRC-32)"
            }
        ));
        JTableArquivosCompartilhados.setToolTipText("Arquivos encontrados");
        JTableArquivosCompartilhados.setMinimumSize(null);
        jScrollPaneArquivosCompartilhados.setViewportView(JTableArquivosCompartilhados);

        jPanelSatusDownload.setBorder(javax.swing.BorderFactory.createTitledBorder("Status do download"));

        jLabelNomeArquivo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelNomeArquivo.setText("Nome do arquivo");

        jLabelStatus.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelStatus.setText("Status:");

        jLabelProgresso.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelProgresso.setText("Progresso");

        lblNomeArquivo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNomeArquivo.setForeground(new java.awt.Color(153, 0, 0));
        lblNomeArquivo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNomeArquivo.setText("Nenhum arquivo");
        lblNomeArquivo.setToolTipText("Baixando arquivo");
        lblNomeArquivo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        lblStatus.setForeground(new java.awt.Color(0, 0, 153));
        lblStatus.setText("Aguardando...");
        lblStatus.setToolTipText("Status do download");

        minhaBarraDeProgresso.setToolTipText("Progresso do download");
        minhaBarraDeProgresso.setStringPainted(true);

        btnVerificarDownload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jxta/icons/icon-verificar.png"))); // NOI18N
        btnVerificarDownload.setText("Verificar");
        btnVerificarDownload.setToolTipText("Verificar arquivo");
        btnVerificarDownload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarDownloadActionPerformed(evt);
            }
        });

        btnCancelarDownload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jxta/icons/icon-cancelar.png"))); // NOI18N
        btnCancelarDownload.setText("Cancelar");
        btnCancelarDownload.setToolTipText("Cancelar download");
        btnCancelarDownload.setEnabled(false);
        btnCancelarDownload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarDownloadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelSatusDownloadLayout = new javax.swing.GroupLayout(jPanelSatusDownload);
        jPanelSatusDownload.setLayout(jPanelSatusDownloadLayout);
        jPanelSatusDownloadLayout.setHorizontalGroup(
            jPanelSatusDownloadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSatusDownloadLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSatusDownloadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelNomeArquivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelProgresso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelSatusDownloadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblStatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
                    .addComponent(minhaBarraDeProgresso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNomeArquivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelSatusDownloadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancelarDownload, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(btnVerificarDownload, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelSatusDownloadLayout.setVerticalGroup(
            jPanelSatusDownloadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSatusDownloadLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSatusDownloadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNomeArquivo)
                    .addComponent(lblNomeArquivo)
                    .addComponent(btnVerificarDownload))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelSatusDownloadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelStatus)
                    .addComponent(lblStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelSatusDownloadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelProgresso)
                    .addComponent(minhaBarraDeProgresso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarDownload))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelArquivosCompartilhadosLayout = new javax.swing.GroupLayout(jPanelArquivosCompartilhados);
        jPanelArquivosCompartilhados.setLayout(jPanelArquivosCompartilhadosLayout);
        jPanelArquivosCompartilhadosLayout.setHorizontalGroup(
            jPanelArquivosCompartilhadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelArquivosCompartilhadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelArquivosCompartilhadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneArquivosCompartilhados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 834, Short.MAX_VALUE)
                    .addGroup(jPanelArquivosCompartilhadosLayout.createSequentialGroup()
                        .addComponent(txtNomeArquivo)
                        .addGap(18, 18, 18)
                        .addComponent(btnPesquisarArquivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPararPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnDownload, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelSatusDownload, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelArquivosCompartilhadosLayout.setVerticalGroup(
            jPanelArquivosCompartilhadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelArquivosCompartilhadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelArquivosCompartilhadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPararPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisarArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPaneArquivosCompartilhados, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDownload, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelSatusDownload, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane.addTab("Pesquisar", new javax.swing.ImageIcon(getClass().getResource("/jxta/icons/icon-pesquisar-tabs.png")), jPanelArquivosCompartilhados, "Pesquisar arquivos compartilhados"); // NOI18N

        jPanelMeusArquivos.setBorder(javax.swing.BorderFactory.createTitledBorder("Meus arquivos compartilhados"));

        meusArquivosCompartilhados.setAutoCreateRowSorter(true);
        meusArquivosCompartilhados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nome do Arquivo", "Tamanho (Bytes)", "Check Sum (CRC-32)"
            }
        ));
        meusArquivosCompartilhados.setToolTipText("Meus arquivos compartilhados");
        jScrollPaneMeusArquivos.setViewportView(meusArquivosCompartilhados);

        btnAtualizarMeusArquivos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jxta/icons/icon-atualizar.png"))); // NOI18N
        btnAtualizarMeusArquivos.setText("Atualizar");
        btnAtualizarMeusArquivos.setToolTipText("");
        btnAtualizarMeusArquivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarMeusArquivosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMeusArquivosLayout = new javax.swing.GroupLayout(jPanelMeusArquivos);
        jPanelMeusArquivos.setLayout(jPanelMeusArquivosLayout);
        jPanelMeusArquivosLayout.setHorizontalGroup(
            jPanelMeusArquivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneMeusArquivos, javax.swing.GroupLayout.DEFAULT_SIZE, 854, Short.MAX_VALUE)
            .addComponent(btnAtualizarMeusArquivos, javax.swing.GroupLayout.DEFAULT_SIZE, 854, Short.MAX_VALUE)
        );
        jPanelMeusArquivosLayout.setVerticalGroup(
            jPanelMeusArquivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMeusArquivosLayout.createSequentialGroup()
                .addComponent(jScrollPaneMeusArquivos, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAtualizarMeusArquivos)
                .addContainerGap())
        );

        jTabbedPane.addTab("Meus Arquivos", new javax.swing.ImageIcon(getClass().getResource("/jxta/icons/icon-pasta-compartilhamento.png")), jPanelMeusArquivos, "Meus arquivos compartilhados"); // NOI18N

        jPanelPeers.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de peers"));

        ListaDePeers.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome dos peers"));
        ListaDePeers.setToolTipText("Lista de peers");
        jScrollPanePeers.setViewportView(ListaDePeers);

        btnPesquisarPeers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jxta/icons/icon-pesquisar-jbooks.png"))); // NOI18N
        btnPesquisarPeers.setText("Procurar Peers");
        btnPesquisarPeers.setToolTipText("Procurar Peers");
        btnPesquisarPeers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarPeersActionPerformed(evt);
            }
        });

        btnPararPesquisaPeers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jxta/icons/icon-parar.png"))); // NOI18N
        btnPararPesquisaPeers.setText("Parar Procura");
        btnPararPesquisaPeers.setToolTipText("Parar Procura");
        btnPararPesquisaPeers.setEnabled(false);
        btnPararPesquisaPeers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPararPesquisaPeersActionPerformed(evt);
            }
        });

        btnConectar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jxta/icons/icon-conectar.png"))); // NOI18N
        btnConectar.setText("Conectar");
        btnConectar.setToolTipText("Conectar");
        btnConectar.setEnabled(false);
        btnConectar.setMaximumSize(new java.awt.Dimension(115, 23));
        btnConectar.setMinimumSize(new java.awt.Dimension(115, 23));
        btnConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConectarActionPerformed(evt);
            }
        });

        btnDesconectar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jxta/icons/icon-disconectar.png"))); // NOI18N
        btnDesconectar.setText("Desconectar");
        btnDesconectar.setMaximumSize(new java.awt.Dimension(115, 23));
        btnDesconectar.setMinimumSize(new java.awt.Dimension(115, 23));
        btnDesconectar.setPreferredSize(new java.awt.Dimension(115, 23));
        btnDesconectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesconectarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelPeersLayout = new javax.swing.GroupLayout(jPanelPeers);
        jPanelPeers.setLayout(jPanelPeersLayout);
        jPanelPeersLayout.setHorizontalGroup(
            jPanelPeersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPeersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPeersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPanePeers, javax.swing.GroupLayout.DEFAULT_SIZE, 834, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPeersLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnPesquisarPeers, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPararPesquisaPeers, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnConectar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDesconectar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114)))
                .addContainerGap())
        );
        jPanelPeersLayout.setVerticalGroup(
            jPanelPeersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPeersLayout.createSequentialGroup()
                .addComponent(jScrollPanePeers, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelPeersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPeersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDesconectar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnConectar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnPararPesquisaPeers))
                    .addComponent(btnPesquisarPeers)))
        );

        jTabbedPane.addTab("Peers", new javax.swing.ImageIcon(getClass().getResource("/jxta/icons/icon-peers.png")), jPanelPeers, "Lista de peers"); // NOI18N

        jLabelSobre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelSobre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSobre.setText("TRABALHO DE CONCLUSÃO DA DISCIPLINA DE SISTEMAS DISTRIBUIDOS DO CENTRO UNIVERSITÁRIO LUTERANO DE PALMAS.");

        jLabelImgLogo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImgLogo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jxta/icons/fundo-jbooks.png"))); // NOI18N

        jLabelDesenvolvedores.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelDesenvolvedores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDesenvolvedores.setText("APLICAÇÃO DESENVOLVIDA POR:");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Jhonatan Silva Mota");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Leomar Camargo de Souza");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Ranyelson Neres Carvalho");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("ORIENTADORA: Prof. M.Sc. Madianita Bogo");

        javax.swing.GroupLayout jPanelSobreLayout = new javax.swing.GroupLayout(jPanelSobre);
        jPanelSobre.setLayout(jPanelSobreLayout);
        jPanelSobreLayout.setHorizontalGroup(
            jPanelSobreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSobreLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 796, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelSobreLayout.createSequentialGroup()
                .addGroup(jPanelSobreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelSobreLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelSobreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelSobre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 846, Short.MAX_VALUE)
                            .addComponent(jLabelDesenvolvedores, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelImgLogo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanelSobreLayout.setVerticalGroup(
            jPanelSobreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSobreLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabelImgLogo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabelSobre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelDesenvolvedores)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(93, 93, 93))
        );

        jTabbedPane.addTab("Sobre", new javax.swing.ImageIcon(getClass().getResource("/jxta/icons/icon-sobre.png")), jPanelSobre); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getAccessibleContext().setAccessibleName("Principal");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceitarTermoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceitarTermoActionPerformed
        this.TermosDeUso.setVisible(false);
    }//GEN-LAST:event_btnAceitarTermoActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnDesconectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesconectarActionPerformed
        try {
            btnConectar.setEnabled(true);
            IniciarCompartilhamento.PararCMS();
            IniciarCompartilhamento = null;
            ListaPeers = null;
            btnDesconectar.setEnabled(false);
            btnPesquisarPeers.setEnabled(false);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERRO: " + ex.getMessage(), "J'Books", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDesconectarActionPerformed

    private void btnConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConectarActionPerformed
        try {
            btnConectar.setEnabled(false);
            ListaPeers = new ListaDePeers(Conexao.getGrupoSistemaDistribuidos(), this.ListaDePeers);
            IniciarCompartilhamento = new GrupoCompartilhamento(Conexao.getGrupoSistemaDistribuidos(), new File(Caminho));
            IniciarCompartilhamento.start();
            btnDesconectar.setEnabled(true);
            btnPesquisarPeers.setEnabled(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERRO: " + ex.getMessage(), "J'Books", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnConectarActionPerformed

    private void btnPararPesquisaPeersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPararPesquisaPeersActionPerformed
        try {
            btnPesquisarPeers.setEnabled(true);
            ListaPeers.setFimDaPesquisa(true);
            ListaPeers = new ListaDePeers(Conexao.getGrupoSistemaDistribuidos(), this.ListaDePeers);
            btnPararPesquisaPeers.setEnabled(false);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERRO: " + ex.getMessage(), "J'Books", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnPararPesquisaPeersActionPerformed

    private void btnPesquisarPeersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarPeersActionPerformed
        try {
            ListaPeers.start();
            btnPesquisarPeers.setEnabled(false);
            btnPararPesquisaPeers.setEnabled(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERRO: " + ex.getMessage(), "J'Books", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnPesquisarPeersActionPerformed

    private void btnAtualizarMeusArquivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarMeusArquivosActionPerformed
        try {
            File diretorio = new File(Caminho);
            File[] listaArquivos = diretorio.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String filename) {
                    return filename.endsWith(".pdf");
                }
            });
            String[] tituloTabela = {"Nome do Arquivo", "Tamanho (Bytes)", "Check Sum (CRC-32)"};
            int qtArquivos = 0;
            for (File listaArquivo : listaArquivos) {
                if (listaArquivo.isFile()) {
                    qtArquivos++;
                }
            }
            DefaultTableModel TableModel = new DefaultTableModel(tituloTabela, qtArquivos) {
                @Override
                public boolean isCellEditable(int rowIndex, int mColIndex) {
                    return false;
                }
            };
            meusArquivosCompartilhados.setModel(TableModel);
            int j = 0;
            for (File listaArquivo : listaArquivos) {
                if (listaArquivo.isFile()) {
                    meusArquivosCompartilhados.setValueAt(listaArquivo.getName(), j, 0);
                    meusArquivosCompartilhados.setValueAt(listaArquivo.length(), j, 1);
                    meusArquivosCompartilhados.setValueAt(MeuCheckSum.getSumArquivo(listaArquivo), j, 2);
                    j++;
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERRO: " + ex.getMessage(), "J'Books", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAtualizarMeusArquivosActionPerformed

    private void btnCancelarDownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarDownloadActionPerformed
        try {
            Download.meuDownload.cancel();
            lblStatus.setText("Download cancelado.");
            minhaBarraDeProgresso.setValue(0);
            btnCancelarDownload.setEnabled(false);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERRO: " + ex.getMessage(), "J'Books", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCancelarDownloadActionPerformed

    private void btnVerificarDownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarDownloadActionPerformed
        if (Download.meuDownload.isDone()) {
            File meuNovoArquivo = new File(Caminho + File.separator + NomeMeuArquivo);
            String novoSum = MeuCheckSum.getSumArquivo(meuNovoArquivo);
            if (novoSum.equals(CheckSumOriginal)) {
                lblStatus.setText("Download concluído");
            } else {
                lblStatus.setText("Arquivo corrompido");
                JOptionPane.showMessageDialog(null, "Arquivo corrompido", "J'Books", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Download não concluído!", "J'Books", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnVerificarDownloadActionPerformed

    private void btnDownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownloadActionPerformed
        try {
            int rowNum;
            if ((rowNum = JTableArquivosCompartilhados.getSelectedRow()) != -1) {
                if (ConteudoCompartilhado != null) {
                    CheckSumOriginal = JTableArquivosCompartilhados.getValueAt(rowNum, 2).toString();
                    NomeMeuArquivo = JTableArquivosCompartilhados.getValueAt(rowNum, 0).toString();
                    lblNomeArquivo.setText(NomeMeuArquivo);
                    lblStatus.setText("Baixando arquivo...");
                    File destinoArquivo = new File(Caminho + File.separator + NomeMeuArquivo);
                    Download = new DownloadArquivo(Conexao.getGrupoSistemaDistribuidos(), ConteudoCompartilhado[rowNum], destinoArquivo, this.minhaBarraDeProgresso);
                    Download.start();
                    btnCancelarDownload.setEnabled(true);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, selecione o arquivo desejado e depois clique em Download!", "J'Books", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERRO: " + ex.getMessage(), "J'Books", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDownloadActionPerformed

    private void btnPararPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPararPesquisaActionPerformed
        try {
            IniciarPesquisa.killThread();
            ConteudoCompartilhado = ListaRequisicao.resultadoPesquisa;
            IniciarPesquisa = null;
            btnPesquisarArquivo.setEnabled(true);
            btnDownload.setEnabled(true);
            btnPararPesquisa.setEnabled(false);
            txtNomeArquivo.setEnabled(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERRO: " + ex.getMessage(), "J'Books", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnPararPesquisaActionPerformed

    private void btnPesquisarArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarArquivoActionPerformed
        try {
            String nomeArquivo = this.txtNomeArquivo.getText();
            if (!"".equals(nomeArquivo)) {
                if (nomeArquivo.contains(".")) {
                    nomeArquivo = nomeArquivo.substring(0, nomeArquivo.lastIndexOf('.'));
                }
                IniciarPesquisa = new PesquisarArquivo(Conexao.getGrupoSistemaDistribuidos(), nomeArquivo + ".pdf", this.JTableArquivosCompartilhados);
                IniciarPesquisa.start();
                btnPesquisarArquivo.setEnabled(false);
                btnPararPesquisa.setEnabled(true);
                btnDownload.setEnabled(false);
                txtNomeArquivo.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(null, "Informe um valor para pesquisa!", "J'Books", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERRO: " + ex.getMessage(), "J'Books", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnPesquisarArquivoActionPerformed

    public static void main(String args[]) {
        try {
            Principal principal = new Principal();
            principal.setVisible(true);
            principal.TermosDeUso.setResizable(true);
            principal.TermosDeUso.setLocationRelativeTo(null);
            principal.TermosDeUso.setVisible(true);
            PrimeiroCheckIn verificar = new PrimeiroCheckIn();
            if (verificar.ehPrimeiraVez()) {
                JOptionPane.showMessageDialog(null, "Selecione sua pasta de compartilhamento", "J'Article", JOptionPane.INFORMATION_MESSAGE);
                verificar.pesquisarArquivoConfiguracao();
                Caminho = verificar.getCaminhoCompartilhado();
            } else {
                verificar.pesquisarArquivoConfiguracao();
                Caminho = verificar.getCaminhoCompartilhado();
            }
            Conexao = new IniciarJXTA();
            ListaPeers = new ListaDePeers(Conexao.getGrupoSistemaDistribuidos(), principal.ListaDePeers);
            IniciarCompartilhamento = new GrupoCompartilhamento(Conexao.getGrupoSistemaDistribuidos(), new File(Caminho));
            IniciarCompartilhamento.start();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERRO: " + ex.getMessage(), "J'Article", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTableArquivosCompartilhados;
    private javax.swing.JList ListaDePeers;
    private javax.swing.JDialog TermosDeUso;
    private javax.swing.JButton btnAceitarTermo;
    private javax.swing.JButton btnAtualizarMeusArquivos;
    private javax.swing.JButton btnCancelarDownload;
    private javax.swing.JButton btnConectar;
    private javax.swing.JButton btnDesconectar;
    private javax.swing.JButton btnDownload;
    private javax.swing.JButton btnPararPesquisa;
    private javax.swing.JButton btnPararPesquisaPeers;
    private javax.swing.JButton btnPesquisarArquivo;
    private javax.swing.JButton btnPesquisarPeers;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnVerificarDownload;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelDesenvolvedores;
    private javax.swing.JLabel jLabelImgLogo;
    private javax.swing.JLabel jLabelImgLogo1;
    private javax.swing.JLabel jLabelNomeArquivo;
    private javax.swing.JLabel jLabelProgresso;
    private javax.swing.JLabel jLabelSobre;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JPanel jPanelArquivosCompartilhados;
    private javax.swing.JPanel jPanelMeusArquivos;
    private javax.swing.JPanel jPanelPeers;
    private javax.swing.JPanel jPanelSatusDownload;
    private javax.swing.JPanel jPanelSobre;
    private javax.swing.JScrollPane jScrollPaneArquivosCompartilhados;
    private javax.swing.JScrollPane jScrollPaneMeusArquivos;
    private javax.swing.JScrollPane jScrollPanePeers;
    private javax.swing.JScrollPane jScrollPaneTermos;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTextArea jTextAreaTermos;
    private javax.swing.JLabel lblNomeArquivo;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JTable meusArquivosCompartilhados;
    private javax.swing.JProgressBar minhaBarraDeProgresso;
    private javax.swing.JTextField txtNomeArquivo;
    // End of variables declaration//GEN-END:variables
}
