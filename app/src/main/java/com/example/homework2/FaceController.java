package com.example.homework2;
// Author: Alex Rogers, CS 301

import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

import com.example.homework2.Face;

public class FaceController implements SeekBar.OnSeekBarChangeListener, RadioGroup.OnCheckedChangeListener, Spinner.OnItemSelectedListener {
    private Face faceView;
    private FaceModel newModel;
    int isSelected = 0;//Logs radio button choice to send to change color with seek bar

    // constructor
    public FaceController(Face view){
        faceView = view;
        newModel = view.getModel();

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
        int seekID = seekBar.getId();
        if(seekID == R.id.redseek ){newModel.setRedValue(progress);}//sets red
        if(seekID == R.id.greenseek ){newModel.setGreenValue(progress);}//sets blue
        if(seekID == R.id.blueseek ){newModel.setBlueValue(progress);}//sets green

        if( isSelected == 0){//sets Skin Color
          faceView.setSkinColor(newModel.getRedValue(),newModel.getGreenValue(),newModel.getBlueValue());
        }
        if( isSelected == 1){//sets Eye Color
            faceView.setEyeColor(newModel.getRedValue(),newModel.getGreenValue(),newModel.getBlueValue());
        }
        if( isSelected == 2){//sets Hair Color
            faceView.setHairColor(newModel.getRedValue(),newModel.getGreenValue(),newModel.getBlueValue());
        }

        faceView.invalidate();
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
        if(id == 0){faceView.setHairStyle(0);}
        if(id == 1){faceView.setHairStyle(1);}
        if(id == 2){faceView.setHairStyle(2);}

        faceView.invalidate();
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent){


    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        int radioID = group.getCheckedRadioButtonId();//checks which radio button was selected
        if(radioID == R.id.skin){ isSelected = 0;}
        if(radioID == R.id.eyes){ isSelected = 1;}
        if(radioID == R.id.hair){ isSelected = 2;}
        if(radioID == R.id.randomize){faceView.randomize();}

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar){

    }

    @Override public void onStopTrackingTouch(SeekBar seekBar){

    }
}
