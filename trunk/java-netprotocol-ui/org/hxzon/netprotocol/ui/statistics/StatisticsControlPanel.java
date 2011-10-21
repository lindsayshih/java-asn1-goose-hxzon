package org.hxzon.netprotocol.ui.statistics;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.prefs.Preferences;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.hxzon.pcap.PcapHandler;
import org.hxzon.swing.layout.simple.SimpleLayout;
import org.hxzon.swing.layout.simple.SimpleLayoutData;
import org.hxzon.util.DebugTimespend;

public class StatisticsControlPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private final PacketCheckBox goose;
    private final PacketCheckBox mms;
    private final PacketCheckBox smv;
    private final PacketCheckBox other;
    private final PacketCheckBox all;
    private final IsPer100ComboBox isPer100;
    private final IsPacketNumComboBox isPacketNum;
    private final AntiAliasCheckBox antiAlias;

    public StatisticsControlPanel(final StatisticsPaintPanel paintPanel) {
//		this.setBackground(backgroundColor);
        final JPanel packetPanel = new JPanel();
        packetPanel.setLayout(new SimpleLayout());
        goose = new PacketCheckBox(paintPanel, "GOOSE", "GOOSE");
        mms = new PacketCheckBox(paintPanel, "MMS", "MMS");
        smv = new PacketCheckBox(paintPanel, "采样值", "采样值");
        other = new PacketCheckBox(paintPanel, "其它报文", "其它报文");
        all = new PacketCheckBox(paintPanel, "全部", "全部");
        packetPanel.add(new JLabel("显示报文类型："));
        packetPanel.add(goose);
        packetPanel.add(mms);
        packetPanel.add(smv);
        packetPanel.add(other);
        packetPanel.add(all);
        packetPanel.add(new JLabel("统计时间间隔："), SimpleLayoutData.fixedSize(25));
        isPer100 = new IsPer100ComboBox(paintPanel);
        packetPanel.add(isPer100);
        packetPanel.add(new JLabel("统计项目："), SimpleLayoutData.fixedSize(25));
        isPacketNum = new IsPacketNumComboBox(paintPanel);
        packetPanel.add(isPacketNum);
        Action openFile = new AbstractAction("打开文件") {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                DebugTimespend.start("open file");
                Preferences prefs = Preferences.userNodeForPackage(this.getClass());
                String filePath = prefs.get("openFile", "");
                JFileChooser chooser = new JFileChooser(filePath);
                chooser.setMultiSelectionEnabled(true);
                int option = chooser.showOpenDialog(SwingUtilities.windowForComponent(packetPanel));
                DebugTimespend.end("open file");
                if (option == JFileChooser.APPROVE_OPTION) {
                    File[] files = chooser.getSelectedFiles();
                    prefs.put("openFile", files[0].getAbsolutePath());
                    DebugTimespend.start("open file:run");
                    PcapHandler handler = new PcapHandler();
                    handler.addListener(new StatisticsListener(paintPanel, StatisticsControlPanel.this));
                    handler.addFiles(files);
                    handler.run();
                    DebugTimespend.end("open file:run");
                    initButton();
                }
            }

        };
        antiAlias = new AntiAliasCheckBox(paintPanel);
        packetPanel.add(antiAlias);
        packetPanel.add(new JLabel("打开文件："), SimpleLayoutData.fixedSize(25));
        packetPanel.add(new JButton(openFile));
        //
        goose.setEnabled(false);
        mms.setEnabled(false);
        smv.setEnabled(false);
        other.setEnabled(false);
        all.setEnabled(false);
        isPer100.setEnabled(false);
        isPacketNum.setEnabled(false);
        antiAlias.setEnabled(false);
        this.add(packetPanel);
    }

    class PacketCheckBox extends JCheckBox {
        private static final long serialVersionUID = 1L;

        public PacketCheckBox(final StatisticsPaintPanel paintPanel, final String name, String desc) {
            super(desc);
            super.setSelected(true);
            this.addItemListener(new ItemListener() {

                @Override
                public void itemStateChanged(ItemEvent e) {
                    boolean selected = e.getStateChange() == ItemEvent.SELECTED;
                    paintPanel.getModel().showData(name, selected);
                    paintPanel.showData(name, selected);
                }
            });
        }
    }

    class AntiAliasCheckBox extends JCheckBox {
        private static final long serialVersionUID = 1L;

        public AntiAliasCheckBox(final StatisticsPaintPanel paintPanel) {
            super("AntiAlias");//抗锯齿,平滑
            super.setSelected(true);
            this.addItemListener(new ItemListener() {

                @Override
                public void itemStateChanged(ItemEvent e) {
                    boolean selected = e.getStateChange() == ItemEvent.SELECTED;
                    paintPanel.useAntiAlias(selected);
                }
            });
        }
    }

    class IsPer100ComboBox extends JComboBox {
        private static final long serialVersionUID = 1L;

        public IsPer100ComboBox(final StatisticsPaintPanel paintPanel) {
            this.addItem(new MyBooleanComboBoxItem("0.1s", true));
            this.addItem(new MyBooleanComboBoxItem("1s", false));
            this.addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        MyBooleanComboBoxItem item = (MyBooleanComboBoxItem) e.getItem();
                        paintPanel.getModel().setPer100(item.b);
                        paintPanel.showDataPer100(item.b);
                    }
                }
            });
        }
    }

    class IsPacketNumComboBox extends JComboBox {
        private static final long serialVersionUID = 1L;

        public IsPacketNumComboBox(final StatisticsPaintPanel paintPanel) {
            this.addItem(new MyBooleanComboBoxItem("比特数", false));
            this.addItem(new MyBooleanComboBoxItem("报文数", true));
            this.addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        MyBooleanComboBoxItem item = (MyBooleanComboBoxItem) e.getItem();
                        paintPanel.getModel().setPacketNum(item.b);
                        paintPanel.updateForPacketNumOrBitNum();
                    }
                }
            });
        }
    }

    class MyBooleanComboBoxItem {
        public String display;
        public boolean b;

        public MyBooleanComboBoxItem(String display, boolean b) {
            this.display = display;
            this.b = b;
        }

        public String toString() {
            return display;
        }
    }

    public void initButton() {
        goose.setEnabled(true);
        mms.setEnabled(true);
        smv.setEnabled(true);
        other.setEnabled(true);
        all.setEnabled(true);
        isPer100.setEnabled(true);
        isPacketNum.setEnabled(true);
        antiAlias.setEnabled(true);
        //
        isPacketNum.setSelectedIndex(0);
        //
        goose.setSelected(true);
        mms.setSelected(true);
        smv.setSelected(true);
        other.setSelected(true);
        all.setSelected(false);
        //
        isPer100.setSelectedIndex(0);
        //
        antiAlias.setSelected(true);
    }
}
