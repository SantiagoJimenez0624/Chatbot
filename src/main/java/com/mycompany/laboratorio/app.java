/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.laboratorio;

import static com.mycompany.laboratorio.Laboratorio.sendRequestToOllama;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author sjime
 */
public class app extends javax.swing.JFrame {
    String[] chatsNames = new String[1000];
    String[][] m = new String[1000][301];
    int indice;
    /**
     * Creates new form app
     */
    public app(String[] chats, String[][]m2) {
        initComponents();
        history.setListData(chats);
        chatsNames = chats;
        m = m2;
        history.setSelectedIndex(0);
        
    }
    private String getResponseFromAPI(String modelName, String promptText) {
        String response;
        String OLLAMA_URL = "http://localhost:11434/api/generate";
        URI uri = URI.create(OLLAMA_URL);

        try {
            response = sendRequestToOllama(modelName, promptText, uri);
        } catch (IOException | InterruptedException e) {
            response = "Error al conectar con Ollama: " + e.getMessage();
            e.printStackTrace();
        }
        
        return response;
    }
    public static String formatResponse(String response, int maxLength) {
        StringBuilder formattedResponse = new StringBuilder();
        int index = 0;

        while (index < response.length()) {
            if (index + maxLength < response.length()) {
                formattedResponse.append(response, index, index + maxLength).append("\n");
            } else {
                formattedResponse.append(response.substring(index));
            }
            index += maxLength;
        }

        return formattedResponse.toString();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        history = new javax.swing.JList<>();
        input = new javax.swing.JTextField();
        send = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(149, 210, 179));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 600));

        history.setBackground(new java.awt.Color(85, 173, 155));
        history.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                historyMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(history);

        input.setToolTipText("");
        input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputActionPerformed(evt);
            }
        });

        send.setBackground(new java.awt.Color(85, 173, 155));
        send.setText("Enviar");
        send.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sendMouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(149, 210, 179));

        jButton1.setBackground(new java.awt.Color(85, 173, 155));
        jButton1.setText("New Chat");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jList1.setBackground(new java.awt.Color(216, 239, 211));
        jList1.setBorder(null);
        jList1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(jList1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setText("ORION");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(310, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(264, 264, 264)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(input)
                        .addGap(18, 18, 18)
                        .addComponent(send, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(input)
                            .addComponent(send, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                        .addGap(12, 12, 12))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputActionPerformed

    private void sendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendMouseClicked
        String pregunta = input.getText();
        input.setText("");
        indice = history.getSelectedIndex();
        int indice2 = 0;
        boolean vacio = false;
        String[] conversation;

        // Buscar el primer índice vacío en m[indice]
        for (int i = 0; i < 300; i++) {
            if (m[indice][i] == null) {
                m[indice][i] = pregunta; // Guardar la pregunta
                vacio = true;
                indice2 = i + 1;
                conversation = Arrays.copyOfRange(m[indice], 0, 301); // Cambiado a 0
                jList1.setListData(conversation);
                JOptionPane.showMessageDialog(null,"Respondiendo");
                break;
            }
        }
        
        
        if (vacio) {
            conversation = Arrays.copyOfRange(m[indice], 0, 301); // Cambiado a 0
            jList1.setListData(conversation);

            // Generar la respuesta usando la IA
            String modelName = "llama3.2";
            String respuesta = getResponseFromAPI(modelName, pregunta);
            respuesta = formatResponse(respuesta,80);

            m[indice][indice2] = respuesta; // Guardar la respuesta

            // Actualizar la conversación en la JList
            conversation = Arrays.copyOfRange(m[indice], 0, 301); // Asegurarse de mostrar todo, incluyendo la pregunta
            jList1.setListData(conversation);
            JOptionPane.showMessageDialog(null, "Chat guardado automaticamente");
        } else {
            JOptionPane.showMessageDialog(null, "No creado", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_sendMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        String name = JOptionPane.showInputDialog("Ingese nombre del nuevo chat");
        boolean vacio = false;
        for (int i = 0; i < 1000; i++) {
            if (chatsNames[i] == null) {
                chatsNames[i] = name;
                vacio = true;
                break;
            }
        }
        if (vacio) {
            history.setListData(chatsNames);
        } else {
            JOptionPane.showMessageDialog(null, "No creado", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void historyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historyMouseClicked
        int index = history.getSelectedIndex();
        String[] conversation = Arrays.copyOfRange(m[index], 0, 301);
        jList1.setListData(conversation);
    }//GEN-LAST:event_historyMouseClicked

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> history;
    private javax.swing.JTextField input;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton send;
    // End of variables declaration//GEN-END:variables
}

