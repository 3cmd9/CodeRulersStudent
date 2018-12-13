/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.mrd.Tournament;

import dev.CodeRulers.entity.Castle;
import dev.CodeRulers.entity.*;
import dev.CodeRulers.ruler.AbstractRuler;

/**
 *
 * @author MikeRD
 */
public class MyRuler extends AbstractRuler{
//public static String tourneyLocation = "";
    @Override
    public void orderSubjects() {
        System.out.println(World.getCurrentTurn());
//           System.out.println(World.getBoardSize());
//   System.out.println(World.getNumRulers());
    }

    @Override
    public void initialize() {
    System.out.println(World.getCurrentTurn());
           System.out.println(World.getBoardSize());
   System.out.println(World.getNumRulers());
    }

    @Override
    public String getSchoolName() {
        return "NHS";
    }

    @Override
    public String getRulerName() {
        return "My Name";
    }
    
}
