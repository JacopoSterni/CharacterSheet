package com.example.charactersheet;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.CREATE;

public class CSheetView {



    @FXML
    private TextField AcrBonus;

    @FXML
    private CheckBox AcrProf;

    @FXML
    private TextField AnHBonus;

    @FXML
    private CheckBox AnHProf;

    @FXML
    private TextField ArcBonus;

    @FXML
    private CheckBox ArcProf;

    @FXML
    private TextField AthBonus;

    @FXML
    private CheckBox AthProf;

    @FXML
    private TextField ChaMod;

    @FXML
    private TextField ChaST;

    @FXML
    private CheckBox ChaSTProf;

    @FXML
    private TextField ChaScore;

    @FXML
    private TextField ConMod;

    @FXML
    private TextField ConST;

    @FXML
    private CheckBox ConSTProf;

    @FXML
    private TextField ConScore;

    @FXML
    private TextField DecBonus;

    @FXML
    private CheckBox DecProf;

    @FXML
    private TextField DexMod;

    @FXML
    private TextField DexST;

    @FXML
    private CheckBox DexSTProf;

    @FXML
    private TextField DexScore;

    @FXML
    private TextField HisBonus;

    @FXML
    private CheckBox HisProf;

    @FXML
    private TextField Initiative;

    @FXML
    private TextField InsBonus;

    @FXML
    private CheckBox InsProf;

    @FXML
    private TextField IntMod;

    @FXML
    private TextField IntST;

    @FXML
    private CheckBox IntSTProf;

    @FXML
    private TextField IntScore;

    @FXML
    private TextField IntimBonus;

    @FXML
    private CheckBox IntimProf;

    @FXML
    private TextField InvBonus;

    @FXML
    private CheckBox InvProf;

    @FXML
    private MenuButton Level1Menu;

    @FXML
    private TextField Level1Name;

    @FXML
    private TextField Level1Rem;

    @FXML
    private MenuButton Level2Menu;

    @FXML
    private TextField Level2Name;

    @FXML
    private TextField Level2Rem;

    @FXML
    private MenuButton Level3Menu;

    @FXML
    private TextField Level3Name;

    @FXML
    private TextField Level3Rem;

    @FXML
    private MenuButton Level4Menu;

    @FXML
    private TextField Level4Name;

    @FXML
    private TextField Level4Rem;

    @FXML
    private MenuButton Level5Menu;

    @FXML
    private TextField Level5Name;

    @FXML
    private TextField Level5Rem;

    @FXML
    private MenuButton Level6Menu;

    @FXML
    private TextField Level6Name;

    @FXML
    private TextField Level6Rem;

    @FXML
    private MenuButton Level7Menu;

    @FXML
    private TextField Level7Name;

    @FXML
    private TextField Level7Rem;

    @FXML
    private MenuButton Level8Menu;

    @FXML
    private TextField Level8Name;

    @FXML
    private TextField Level8Rem;

    @FXML
    private MenuButton Level9Menu;

    @FXML
    private TextField Level9Name;

    @FXML
    private TextField Level9Rem;

    @FXML
    private TextField MedBonus;

    @FXML
    private CheckBox MedProf;

    @FXML
    private TextField NatBonus;

    @FXML
    private CheckBox NatProf;

    @FXML
    private TextField PassPerc;

    @FXML
    private TextField PercBonus;

    @FXML
    private CheckBox PercProf;

    @FXML
    private TextField PerfBonus;

    @FXML
    private CheckBox PerfProf;

    @FXML
    private TextField PersBonus;

    @FXML
    private CheckBox PersProf;

    @FXML
    private TextField ProfBonus;

    @FXML
    private TextField RelBonus;

    @FXML
    private CheckBox RelProf;

    @FXML
    private TextField SoHBonus;

    @FXML
    private CheckBox SoHProf;

    @FXML
    private TextField SteBonus;

    @FXML
    private CheckBox SteProf;

    @FXML
    private TextField StrMod;

    @FXML
    private TextField StrST;

    @FXML
    private CheckBox StrSTProf;

    @FXML
    private TextField StrScore;

    @FXML
    private TextField SurBonus;

    @FXML
    private CheckBox SurProf;

    @FXML
    private TextField WisMod;

    @FXML
    private TextField WisST;

    @FXML
    private CheckBox WisSTProf;

    @FXML
    private TextField WisScore;

    @FXML
    private ImageView CharacterImage;

    @FXML
    private Button SaveBtn;

    @FXML
    private TabPane Root;



    @FXML
    void ImageSelection(ActionEvent event) {

    }
    @FXML
    void SaveSheet(ActionEvent event) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save");
        Path dirstart = Paths.get(System.getProperty("user.home") + File.separator + "Documents" + File.separator + "CharacterSheets");
        if (!dirstart.toFile().exists()) {
            try {
                Files.createDirectory(dirstart);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        fileChooser.setInitialDirectory(dirstart.toFile());
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Character Sheet", "*.fxml"));
        File f = fileChooser.showSaveDialog(Root.getScene().getWindow());
        if (f != null) {
            ObservableList<Node> children = Root.getChildrenUnmodifiable();
            Values values = new Values();
            children.stream().filter(child -> child.getId() != null)
                    .forEach(child -> {
                        if (child instanceof TextField) {
                            TextField field = (TextField) child;
                            values.setFieldText(field.getText());
                        } else if (child instanceof TextArea) {
                            TextArea area = (TextArea) child;
                            values.setAreaText(area.getText());
                        }
                    });

            /*try {


                org.apache.commons.io.FileUtils.write(f, new Gson().toJson(values), StandardCharsets.UTF_8);


            } catch (IOException e) {
                // handle properly

            }*/
        }
    }

    @FXML
    void Add1LvlSpell(ActionEvent event) {
        RadioMenuItem raditem = new RadioMenuItem();
        raditem.setText(Level1Name.getText());
        Level1Menu.getItems().add(raditem);

    }
    @FXML
    void Add2LvlSpell(ActionEvent event) {
        RadioMenuItem raditem = new RadioMenuItem();
        raditem.setText(Level2Name.getText());
        Level2Menu.getItems().add(raditem);
    }

    @FXML
    void Add3LvlSpell(ActionEvent event) {
        RadioMenuItem raditem = new RadioMenuItem();
        raditem.setText(Level3Name.getText());
        Level3Menu.getItems().add(raditem);
    }

    @FXML
    void Add4LvlSpell(ActionEvent event) {
        RadioMenuItem raditem = new RadioMenuItem();
        raditem.setText(Level4Name.getText());
        Level4Menu.getItems().add(raditem);
    }

    @FXML
    void Add5LvlSpell(ActionEvent event) {
        RadioMenuItem raditem = new RadioMenuItem();
        raditem.setText(Level5Name.getText());
        Level5Menu.getItems().add(raditem);
    }

    @FXML
    void Add6LvlSpell(ActionEvent event) {
        RadioMenuItem raditem = new RadioMenuItem();
        raditem.setText(Level6Name.getText());
        Level6Menu.getItems().add(raditem);
    }

    @FXML
    void Add7LvlSpell(ActionEvent event) {
        RadioMenuItem raditem = new RadioMenuItem();
        raditem.setText(Level7Name.getText());
        Level7Menu.getItems().add(raditem);
    }

    @FXML
    void Add8LvlSpell(ActionEvent event) {
        RadioMenuItem raditem = new RadioMenuItem();
        raditem.setText(Level8Name.getText());
        Level8Menu.getItems().add(raditem);
    }

    @FXML
    void Add9LvlSpell(ActionEvent event) {
        RadioMenuItem raditem = new RadioMenuItem();
        raditem.setText(Level9Name.getText());
        Level9Menu.getItems().add(raditem);
    }
    @FXML
    void RemoveLvl1Spell(ActionEvent event) {
        for(MenuItem i:Level1Menu.getItems()){

            if(i.getText() != null && i.getText().equals(Level1Rem.getText()))
                Level1Menu.getItems().remove(i);
        }
    }

    @FXML
    void RemoveLvl2Spell(ActionEvent event) {
        for(MenuItem i:Level2Menu.getItems()){
            if(i.getText() != null && i.getText().equals(Level2Rem.getText()))
                Level2Menu.getItems().remove(i);
        }
    }

    @FXML
    void RemoveLvl3Spell(ActionEvent event) {
        for(MenuItem i:Level3Menu.getItems()){
            if(i.getText() != null && i.getText().equals(Level3Rem.getText()))
                Level3Menu.getItems().remove(i);
        }
    }

    @FXML
    void RemoveLvl4Spell(ActionEvent event) {
        for(MenuItem i:Level4Menu.getItems()){
            if(i.getText() != null && i.getText().equals(Level4Rem.getText()))
                Level4Menu.getItems().remove(i);
        }
    }

    @FXML
    void RemoveLvl5Spell(ActionEvent event) {
        for(MenuItem i:Level5Menu.getItems()){
            if(i.getText() != null && i.getText().equals(Level5Rem.getText()))
                Level5Menu.getItems().remove(i);
        }
    }

    @FXML
    void RemoveLvl6Spell(ActionEvent event) {
        for(MenuItem i:Level6Menu.getItems()){
            if(i.getText() != null && i.getText().equals(Level6Rem.getText()))
                Level6Menu.getItems().remove(i);
        }
    }

    @FXML
    void RemoveLvl7Spell(ActionEvent event) {
        for(MenuItem i:Level7Menu.getItems()){
            if(i.getText() != null && i.getText().equals(Level7Rem.getText()))
                Level7Menu.getItems().remove(i);
        }
    }

    @FXML
    void RemoveLvl8Spell(ActionEvent event) {
        for(MenuItem i:Level8Menu.getItems()){
            if(i.getText() != null && i.getText().equals(Level8Rem.getText()))
                Level8Menu.getItems().remove(i);
        }
    }

    @FXML
    void RemoveLvl9Spell(ActionEvent event) {
        for(MenuItem i:Level9Menu.getItems()){
            if(i.getText() != null && i.getText().equals(Level9Rem.getText()))
                Level9Menu.getItems().remove(i);
        }
    }

    @FXML
    void ChaModUpdate(ActionEvent event) {
        ChaMod.setText(String.valueOf((Integer.parseInt(ChaScore.getText())-10)/2));
        //Saving Throw
        if(ChaSTProf.isSelected())
            ChaST.setText(String.valueOf(Integer.parseInt(ChaMod.getText())+Integer.parseInt(ProfBonus.getText())));
        else
            ChaST.setText(String.valueOf(Integer.parseInt(ChaMod.getText())));
        //Ability
        if(DecProf.isSelected())
            DecBonus.setText(String.valueOf(Integer.parseInt(ChaMod.getText())+Integer.parseInt(ProfBonus.getText())));
        else
            DecBonus.setText(String.valueOf(Integer.parseInt(ChaMod.getText())));
        if(IntimProf.isSelected())
            IntimBonus.setText(String.valueOf(Integer.parseInt(ChaMod.getText())+Integer.parseInt(ProfBonus.getText())));
        else
            IntimBonus.setText(String.valueOf(Integer.parseInt(ChaMod.getText())));
        if(PerfProf.isSelected())
            PerfBonus.setText(String.valueOf(Integer.parseInt(ChaMod.getText())+Integer.parseInt(ProfBonus.getText())));
        else
            PerfBonus.setText(String.valueOf(Integer.parseInt(ChaMod.getText())));
        if(PersProf.isSelected())
            PersBonus.setText(String.valueOf(Integer.parseInt(ChaMod.getText())+Integer.parseInt(ProfBonus.getText())));
        else
            PersBonus.setText(String.valueOf(Integer.parseInt(ChaMod.getText())));

    }

    @FXML
    void ConModUpdate(ActionEvent event) {
        ConMod.setText(String.valueOf((Integer.parseInt(ConScore.getText())-10)/2));
        //Saving Throw
        if(ConSTProf.isSelected())
            ConST.setText(String.valueOf(Integer.parseInt(ConMod.getText())+Integer.parseInt(ProfBonus.getText())));
        else
            ConST.setText(String.valueOf(Integer.parseInt(ConMod.getText())));

    }

    @FXML
    void DexModUpdate(ActionEvent event) {
        DexMod.setText(String.valueOf((Integer.parseInt(DexScore.getText())-10)/2));
        //Saving Throw
        if(DexSTProf.isSelected())
            DexST.setText(String.valueOf(Integer.parseInt(DexMod.getText())+Integer.parseInt(ProfBonus.getText())));
        else
            DexST.setText(String.valueOf(Integer.parseInt(DexMod.getText())));
        //Ability
        if(AcrProf.isSelected())
            AcrBonus.setText(String.valueOf(Integer.parseInt(DexMod.getText())+Integer.parseInt(ProfBonus.getText())));
        else
            AcrBonus.setText(String.valueOf(Integer.parseInt(DexMod.getText())));
        if(SoHProf.isSelected())
            SoHBonus.setText(String.valueOf(Integer.parseInt(DexMod.getText())+Integer.parseInt(ProfBonus.getText())));
        else
            SoHBonus.setText(String.valueOf(Integer.parseInt(DexMod.getText())));
        if(SteProf.isSelected())
            SteBonus.setText(String.valueOf(Integer.parseInt(DexMod.getText())+Integer.parseInt(ProfBonus.getText())));
        else
            SteBonus.setText(String.valueOf(Integer.parseInt(DexMod.getText())));
        //Initiative
        Initiative.setText(DexMod.getText());
    }

    @FXML
    void IntModUpdate(ActionEvent event) {
        IntMod.setText(String.valueOf((Integer.parseInt(IntScore.getText())-10)/2));
        //Saving Throw
        if(IntSTProf.isSelected())
            IntST.setText(String.valueOf(Integer.parseInt(IntMod.getText())+Integer.parseInt(ProfBonus.getText())));
        else
            IntST.setText(String.valueOf(Integer.parseInt(IntMod.getText())));
        //Ability
        if(ArcProf.isSelected())
            ArcBonus.setText(String.valueOf(Integer.parseInt(IntMod.getText())+Integer.parseInt(ProfBonus.getText())));
        else
            ArcBonus.setText(String.valueOf(Integer.parseInt(IntMod.getText())));
        if(HisProf.isSelected())
            HisBonus.setText(String.valueOf(Integer.parseInt(IntMod.getText())+Integer.parseInt(ProfBonus.getText())));
        else
            HisBonus.setText(String.valueOf(Integer.parseInt(IntMod.getText())));
        if(InvProf.isSelected())
            InvBonus.setText(String.valueOf(Integer.parseInt(IntMod.getText())+Integer.parseInt(ProfBonus.getText())));
        else
            InvBonus.setText(String.valueOf(Integer.parseInt(IntMod.getText())));
        if(NatProf.isSelected())
            NatBonus.setText(String.valueOf(Integer.parseInt(IntMod.getText())+Integer.parseInt(ProfBonus.getText())));
        else
            NatBonus.setText(String.valueOf(Integer.parseInt(IntMod.getText())));
        if(RelProf.isSelected())
            RelBonus.setText(String.valueOf(Integer.parseInt(IntMod.getText())+Integer.parseInt(ProfBonus.getText())));
        else
            RelBonus.setText(String.valueOf(Integer.parseInt(IntMod.getText())));

    }

    @FXML
    void StrModUpdate(ActionEvent event) {
        StrMod.setText(String.valueOf((Integer.parseInt(StrScore.getText())-10)/2));
        //Saving Throw
        if(StrSTProf.isSelected())
            StrST.setText(String.valueOf(Integer.parseInt(StrMod.getText())+Integer.parseInt(ProfBonus.getText())));
        else
            StrST.setText(String.valueOf(Integer.parseInt(StrMod.getText())));
        //Ability
        if(AthProf.isSelected())
            AthBonus.setText(String.valueOf(Integer.parseInt(StrMod.getText())+Integer.parseInt(ProfBonus.getText())));
        else
            AthBonus.setText(String.valueOf(Integer.parseInt(StrMod.getText())));

    }

    @FXML
    void WisModUpdate(ActionEvent event) {
        WisMod.setText(String.valueOf((Integer.parseInt(WisScore.getText())-10)/2));
        //Saving Throw
        if(WisSTProf.isSelected())
            WisST.setText(String.valueOf(Integer.parseInt(WisMod.getText())+Integer.parseInt(ProfBonus.getText())));
        else
            WisST.setText(String.valueOf(Integer.parseInt(WisMod.getText())));
        //Ability
        if(AnHProf.isSelected())
            AnHBonus.setText(String.valueOf(Integer.parseInt(WisMod.getText())+Integer.parseInt(ProfBonus.getText())));
        else
            AnHBonus.setText(String.valueOf(Integer.parseInt(WisMod.getText())));
        if(InsProf.isSelected())
            InsBonus.setText(String.valueOf(Integer.parseInt(WisMod.getText())+Integer.parseInt(ProfBonus.getText())));
        else
            InsBonus.setText(String.valueOf(Integer.parseInt(WisMod.getText())));
        if(MedProf.isSelected())
            MedBonus.setText(String.valueOf(Integer.parseInt(WisMod.getText())+Integer.parseInt(ProfBonus.getText())));
        else
            MedBonus.setText(String.valueOf(Integer.parseInt(WisMod.getText())));
        if(PercProf.isSelected()) {
            PercBonus.setText(String.valueOf(Integer.parseInt(WisMod.getText()) + Integer.parseInt(ProfBonus.getText())));
            PassPerc.setText(String.valueOf(Integer.parseInt(WisMod.getText()) + Integer.parseInt(ProfBonus.getText())));
        }else {
            PercBonus.setText(String.valueOf(Integer.parseInt(WisMod.getText())));
            PassPerc.setText(String.valueOf(Integer.parseInt(WisMod.getText())));

        }
        if(SurProf.isSelected())
            SurBonus.setText(String.valueOf(Integer.parseInt(WisMod.getText())+Integer.parseInt(ProfBonus.getText())));
        else
            SurBonus.setText(String.valueOf(Integer.parseInt(WisMod.getText())));

    }

}

// ChaMod.setText(String.valueOf((Integer.parseInt(ChaScore.getText())-10)/2));