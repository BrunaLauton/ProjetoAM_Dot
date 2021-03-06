/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.dot.form;

import br.dot.dao.GrupoDAO;
import br.dot.dao.LancamentoDAO;
import br.dot.dao.LoginDAO;
import br.dot.dao.PreLancamentoDAO;
import br.dot.modelo.Grupo;
import br.dot.modelo.Lancamento;
import br.dot.modelo.PreLancamento;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author bruna
 */
public class FormLancamento extends javax.swing.JFrame {

     private String[][] matriz;
     private SimpleDateFormat dataFormatada;
     
    public FormLancamento() {
        initComponents();
        setLocationRelativeTo(null);
        
        GrupoDAO dao = new GrupoDAO();
        List myList = dao.pegarGrupos();
        
        for(Object i: myList){
            cmbGrupo.addItem((String) i);
        }
        
        PreLancamentoDAO daoPre = new PreLancamentoDAO();
        List myListPre = daoPre.pegarPreLancamentos();
        
        for(Object i: myListPre){
            cmbPre.addItem(Integer.toString((Integer)i));
        }
    }
    
    private void atualizarTabela() {

        LancamentoDAO dao = new LancamentoDAO();
        List<Lancamento> lista = dao.listarLancamento();
        gerarMatriz(lista);
        TableModel modelo = new DefaultTableModel(matriz, 
                new String[]{"Código do Lançamento","Altitude Máxima", "Velocidade Máxima", "Tempo Propulsão", "Pico Aceleração", "Aceleração Média", "Tempo Queda", "Tempo Ejeção", "Altitude Ejeção", "Taxa Descida", "Duração Voo", "Distância do Alvo", "Data do Lançamento"});
        tableLancamento.setModel(modelo);

    }
    
    private void gerarMatriz(List<Lancamento> lista) {
        matriz = new String[lista.size()][13];
       Lancamento lancamento;
       dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
        for (int k = 0; k < lista.size(); k++) {
            lancamento = lista.get(k);

            matriz[k][0] = Integer.toString(lancamento.getIdLancamento());
            matriz[k][1] = Double.toString(lancamento.getAltitudeMax());
            matriz[k][2] = Double.toString(lancamento.getVelocidadeMax());
            matriz[k][3] = Double.toString(lancamento.getTempoPropulsao());
            matriz[k][4] = Double.toString(lancamento.getPicoAceleracao());
            matriz[k][5] = Double.toString(lancamento.getAceleracaoMedia());
            matriz[k][6] = Double.toString(lancamento.getTempoQueda());
            matriz[k][7] = Double.toString(lancamento.getTempoEjecao());
            matriz[k][8] = Double.toString(lancamento.getAltitudeEjecao());
            matriz[k][9] = Double.toString(lancamento.getTaxaDescida());
            matriz[k][10] = Double.toString(lancamento.getDuracaoVoo());
            matriz[k][11] = Double.toString(lancamento.getDistanciaDoAlvo());
            matriz[k][12] = dataFormatada.format(lancamento.getData());

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PnlLancamento = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDistanciaAlvo = new javax.swing.JTextField();
        txtAceleracaoMedia = new javax.swing.JTextField();
        txtAltitudeMax = new javax.swing.JTextField();
        txtTempoPropulsao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtPicoAceleracao = new javax.swing.JTextField();
        txtVelocidadeMax = new javax.swing.JTextField();
        txtDuracaoVoo = new javax.swing.JTextField();
        txtTaxaDescida = new javax.swing.JTextField();
        txtAltitudeEjecao = new javax.swing.JTextField();
        txtTempoEjecao = new javax.swing.JTextField();
        txtTempoQueda = new javax.swing.JTextField();
        cmbPre = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cmbGrupo = new javax.swing.JComboBox<>();
        txtData = new javax.swing.JFormattedTextField();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableLancamento = new javax.swing.JTable();
        btnSalvar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        PnlLancamento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        PnlLancamento.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel1.setText("Altitude Máxima:");
        PnlLancamento.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel2.setText("Velocidade Máxima:");
        PnlLancamento.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel3.setText("Tempo Propulsão:");
        PnlLancamento.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel4.setText("Pré-Lançamento:");
        PnlLancamento.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 360, -1, -1));

        txtDistanciaAlvo.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        PnlLancamento.add(txtDistanciaAlvo, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 260, 180, -1));

        txtAceleracaoMedia.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        PnlLancamento.add(txtAceleracaoMedia, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 180, -1));

        txtAltitudeMax.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        PnlLancamento.add(txtAltitudeMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 180, -1));

        txtTempoPropulsao.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        PnlLancamento.add(txtTempoPropulsao, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 180, -1));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel5.setText("Pico Aceleração:");
        PnlLancamento.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel6.setText("Aceleração Média:");
        PnlLancamento.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel7.setText("Tempo Queda:");
        PnlLancamento.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel8.setText("Duração Vôo:");
        PnlLancamento.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, -1, -1));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel9.setText("Taxa Descida:");
        PnlLancamento.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, -1, -1));

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel10.setText("Altitude Ejeção:");
        PnlLancamento.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, -1, -1));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel11.setText("Tempo Ejeção:");
        PnlLancamento.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, -1, -1));

        txtPicoAceleracao.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        PnlLancamento.add(txtPicoAceleracao, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 180, -1));

        txtVelocidadeMax.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        PnlLancamento.add(txtVelocidadeMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 180, -1));

        txtDuracaoVoo.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        PnlLancamento.add(txtDuracaoVoo, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 200, 180, -1));

        txtTaxaDescida.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        PnlLancamento.add(txtTaxaDescida, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 140, 180, -1));

        txtAltitudeEjecao.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        PnlLancamento.add(txtAltitudeEjecao, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, 180, -1));

        txtTempoEjecao.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        PnlLancamento.add(txtTempoEjecao, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, 180, -1));

        txtTempoQueda.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        PnlLancamento.add(txtTempoQueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 180, -1));

        cmbPre.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        PnlLancamento.add(cmbPre, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 360, 180, 30));

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel13.setText("Distância do Alvo:");
        PnlLancamento.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, -1, -1));

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel14.setText("Grupo:");
        PnlLancamento.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 70, -1));

        cmbGrupo.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        cmbGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbGrupoActionPerformed(evt);
            }
        });
        PnlLancamento.add(cmbGrupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, 180, 30));

        try {
            txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtData.setToolTipText("");
        PnlLancamento.add(txtData, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 310, 180, 30));

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel15.setText("Data:");
        PnlLancamento.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 320, -1, -1));

        tableLancamento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        tableLancamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableLancamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableLancamentoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableLancamento);

        btnSalvar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnAlterar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnPesquisar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel12.setText("Lançamentos");

        btnSair.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnVoltar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnLimpar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        btnExit.setBackground(new java.awt.Color(0, 0, 0));
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/exit.png"))); // NOI18N
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLimpar)
                .addGap(55, 55, 55)
                .addComponent(btnVoltar)
                .addGap(56, 56, 56)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(329, 329, 329)
                        .addComponent(jLabel12))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(btnSalvar)
                        .addGap(78, 78, 78)
                        .addComponent(btnAlterar)
                        .addGap(79, 79, 79)
                        .addComponent(btnPesquisar)
                        .addGap(79, 79, 79)
                        .addComponent(btnExcluir))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PnlLancamento, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel12)
                .addGap(11, 11, 11)
                .addComponent(PnlLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limpar();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        int resposta = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja voltar ao menu?");
        if(resposta == JOptionPane.YES_OPTION) {
             FormMenu fmenu = new FormMenu();
                dispose();
                fmenu.setVisible(true);;
        } 
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
       int resposta = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja finalizar o programa?");
        if(resposta == JOptionPane.YES_OPTION) {
            LoginDAO login = new LoginDAO();
            login.updateLoginOFF();
            System.exit(0);
        } 
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
         int resposta = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja fechar e sair do programa?");
            if(resposta == JOptionPane.YES_OPTION) {
                LoginDAO login = new LoginDAO();
                login.updateLoginOFF();
                System.exit(0);
             } 
    }//GEN-LAST:event_btnExitActionPerformed

    private void cmbGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbGrupoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbGrupoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        
       double altMax = Double.parseDouble(txtAltitudeMax.getText());
       double veloMax = Double.parseDouble(txtVelocidadeMax.getText());
       double tempProp = Double.parseDouble(txtTempoPropulsao.getText());
       double picoAcel = Double.parseDouble(txtPicoAceleracao.getText());
       double acelMed = Double.parseDouble(txtAceleracaoMedia.getText());
       double tempQueda = Double.parseDouble(txtTempoQueda.getText());
       double tempEjec = Double.parseDouble(txtTempoEjecao.getText());
       double altEjec = Double.parseDouble(txtAltitudeEjecao.getText());
       double taxDesc = Double.parseDouble(txtTaxaDescida.getText());
       double duraVoo = Double.parseDouble(txtDuracaoVoo.getText());
       double distAlvo = Double.parseDouble(txtDistanciaAlvo.getText());
       String data = txtData.getText();
       String idPre = cmbPre.getSelectedItem().toString();
       String nomeGrupo = cmbGrupo.getSelectedItem().toString();
        
        if(altMax != 0 || veloMax != 0 || tempProp != 0 || picoAcel != 0 || acelMed != 0 || tempQueda != 0 || tempEjec != 0
        || altEjec != 0 || taxDesc != 0 || duraVoo != 0 || distAlvo != 0 || !data.equals("") || !idPre.equals("") || !nomeGrupo.equals("")){
             try {
                 
                GrupoDAO daoGrupo = new GrupoDAO();
                Grupo grupo;
                grupo = daoGrupo.pegarGrupoPeloNome(nomeGrupo);
                
                PreLancamentoDAO daoPre = new PreLancamentoDAO();
                PreLancamento pre;
                pre = daoPre.pegarPrePeloId(idPre);
                
                SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
                Date date = new java.sql.Date(f.parse(data).getTime());
                
                Lancamento lancamento = new Lancamento(0, altMax, veloMax, tempProp, picoAcel, acelMed, tempQueda, tempEjec, altEjec,
                       taxDesc, duraVoo, distAlvo, date, pre, grupo, null);
                LancamentoDAO dao = new LancamentoDAO();
                boolean insert = dao.cadastrarLancamento(lancamento);
                if(insert){
                     JOptionPane.showMessageDialog(null, "\nRegistro inserido com sucesso!");           
                     limpar();
                     atualizarTabela();     
                }else            
                     JOptionPane.showMessageDialog(null, "\nFalha ao inserir registro!");     
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex + "\nTodos os campos prescisam ser preenchidos com valores validos!");
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, ex + "\nTodos os campos prescisam ser preenchidos com valores validos!");
           }
        }
        else{
           JOptionPane.showMessageDialog(null, "Todos os campos prescisam ser preenchidos!");
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void tableLancamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableLancamentoMouseClicked
        int linha = tableLancamento.getSelectedRow();
        if (linha != -1) {

            txtAltitudeMax.setText(matriz[linha][1]);
            txtVelocidadeMax.setText(matriz[linha][2]);
            txtTempoPropulsao.setText(matriz[linha][3]);
            txtPicoAceleracao.setText(matriz[linha][4]);
            txtAceleracaoMedia.setText(matriz[linha][5]);
            txtTempoQueda.setText(matriz[linha][6]);
            txtTempoEjecao.setText(matriz[linha][7]);
            txtAltitudeEjecao.setText(matriz[linha][8]);
            txtTaxaDescida.setText(matriz[linha][9]);
            txtDuracaoVoo.setText(matriz[linha][10]);
            txtDistanciaAlvo.setText(matriz[linha][11]);
            txtData.setText(matriz[linha][12]);
               
        }
    }//GEN-LAST:event_tableLancamentoMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        atualizarTabela();
    }//GEN-LAST:event_formWindowOpened

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here: 
        double alt = Double.parseDouble(txtAltitudeMax.getText());
        LancamentoDAO dao = new LancamentoDAO();
        boolean result = dao.ExcluirLancamentoPelaAlt(alt);
        if(result){
            limpar();
            atualizarTabela();
            JOptionPane.showMessageDialog(null, "Lancamento excluido com sucesso!\n");
        }        
        else
            JOptionPane.showMessageDialog(null, "Falha ao excluir Lancamento!\n");
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        // TODO add your handling code here:
        double alt = Double.parseDouble(txtAltitudeMax.getText());
        LancamentoDAO dao = new LancamentoDAO();
        
         try {
            Lancamento lancamento = dao.PesquisarLancamentoPelaAlt(alt);
            txtAltitudeMax.setText(Double.toString(lancamento.getAltitudeMax()));
            txtVelocidadeMax.setText(Double.toString(lancamento.getVelocidadeMax()));
            txtTempoPropulsao.setText(Double.toString(lancamento.getTempoPropulsao()));
            txtPicoAceleracao.setText(Double.toString(lancamento.getPicoAceleracao()));
            txtAceleracaoMedia.setText(Double.toString(lancamento.getAceleracaoMedia()));
            txtTempoQueda.setText(Double.toString(lancamento.getTempoQueda()));
            txtTempoEjecao.setText(Double.toString(lancamento.getTempoEjecao()));
            txtAltitudeEjecao.setText(Double.toString(lancamento.getAltitudeEjecao()));
            txtTaxaDescida.setText(Double.toString(lancamento.getTaxaDescida()));
            txtDuracaoVoo.setText(Double.toString(lancamento.getDuracaoVoo()));
            txtDistanciaAlvo.setText(Double.toString(lancamento.getDistanciaDoAlvo()));
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            String data = df.format(lancamento.getData());
            txtData.setText(data);
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro ao pesquisar PreLancameto!\n"+ex);
         }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        // TODO add your handling code here:
        try {
        double altMax = Double.parseDouble(txtAltitudeMax.getText());
        double veloMax = Double.parseDouble(txtVelocidadeMax.getText());
        double tempProp = Double.parseDouble(txtTempoPropulsao.getText());
        double picoAcel = Double.parseDouble(txtPicoAceleracao.getText());
        double acelMed = Double.parseDouble(txtAceleracaoMedia.getText());
        double tempQueda = Double.parseDouble(txtTempoQueda.getText());
        double tempEjec = Double.parseDouble(txtTempoEjecao.getText());
        double altEjec = Double.parseDouble(txtAltitudeEjecao.getText());
        double taxDesc = Double.parseDouble(txtTaxaDescida.getText());
        double duraVoo = Double.parseDouble(txtDuracaoVoo.getText());
        double distAlvo = Double.parseDouble(txtDistanciaAlvo.getText());
        String data = txtData.getText();
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new java.sql.Date(f.parse(data).getTime());
        LancamentoDAO dao = new LancamentoDAO();
        boolean result = dao.AlterarPreLancamentoPelaAlt(altMax, veloMax, tempProp, picoAcel, acelMed, tempQueda, tempEjec,
                                                         altEjec, taxDesc, duraVoo, distAlvo, date);
        if(result){
            limpar();
            atualizarTabela();
            JOptionPane.showMessageDialog(null, "Usuarío alterado com sucesso!\n");
        }        
        else
            JOptionPane.showMessageDialog(null, "Falha ao alterar usuarío!\n");
        } catch (ParseException ex) {
             JOptionPane.showMessageDialog(null, "A data não é valida!\n"+ex);
        }
    }//GEN-LAST:event_btnAlterarActionPerformed
 
    private void limpar() {
       txtAceleracaoMedia.setText("");
       txtAltitudeEjecao.setText("");
       txtDistanciaAlvo.setText("");
       txtAltitudeMax.setText("");
       txtDuracaoVoo.setText("");
       txtPicoAceleracao.setText("");
       txtTaxaDescida.setText("");
       txtTempoEjecao.setText("");
       txtTempoPropulsao.setText("");
       txtTempoQueda.setText("");
       txtVelocidadeMax.setText("");
       txtData.setText("");
              
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormLancamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormLancamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormLancamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormLancamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormLancamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PnlLancamento;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cmbGrupo;
    private javax.swing.JComboBox<String> cmbPre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableLancamento;
    private javax.swing.JTextField txtAceleracaoMedia;
    private javax.swing.JTextField txtAltitudeEjecao;
    private javax.swing.JTextField txtAltitudeMax;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtDistanciaAlvo;
    private javax.swing.JTextField txtDuracaoVoo;
    private javax.swing.JTextField txtPicoAceleracao;
    private javax.swing.JTextField txtTaxaDescida;
    private javax.swing.JTextField txtTempoEjecao;
    private javax.swing.JTextField txtTempoPropulsao;
    private javax.swing.JTextField txtTempoQueda;
    private javax.swing.JTextField txtVelocidadeMax;
    // End of variables declaration//GEN-END:variables
}
