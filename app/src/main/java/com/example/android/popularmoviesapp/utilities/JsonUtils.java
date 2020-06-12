package com.example.android.popularmoviesapp.utilities;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        try {
            List<String> parsedIngredients = new ArrayList<>();
            List<String> parsedAlsoKnownAs = new ArrayList<>();
            JSONObject sandwichDetails = new JSONObject(json);
            String placeOfOrigin = sandwichDetails.getString("placeOfOrigin");
            String description = sandwichDetails.getString("description");
            String image = sandwichDetails.getString("image");
            JSONArray ingredientsJson = sandwichDetails.getJSONArray("ingredients");


            for(int i =0; i< ingredientsJson.length();i++){
                parsedIngredients.add(ingredientsJson.getString(i));
            }
            JSONObject name = sandwichDetails.getJSONObject("name");
            String mainName = name.getString("mainName");
            JSONArray alsoKnownAs = name.getJSONArray("alsoKnownAs");



            for(int i =0; i< alsoKnownAs.length();i++){
                parsedAlsoKnownAs.add(alsoKnownAs.getString(i));
            }

            Sandwich sandwich = new Sandwich(mainName,parsedAlsoKnownAs,placeOfOrigin, description, image, parsedIngredients);

            return sandwich;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }



    }
}
