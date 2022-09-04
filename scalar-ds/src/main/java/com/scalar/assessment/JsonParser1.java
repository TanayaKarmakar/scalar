package com.scalar.assessment;

import com.google.gson.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 28/08/22
 * @project scalar-ds
 */

class User {
    private int id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String website;
    private Company company;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getWebsite() {
        return website;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }

    static class Company {
        private String name;
        private String basename;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBasename() {
            return basename;
        }

        public void setBasename(String basename) {
            this.basename = basename;
        }
    }


    static class Address {
        private String street;
        private String suite;
        private String city;
        private String zipcode;
        private Location geo;

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getSuite() {
            return suite;
        }

        public void setSuite(String suite) {
            this.suite = suite;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }

        public Location getGeo() {
            return geo;
        }

        public void setGeo(Location geo) {
            this.geo = geo;
        }

        static class Location {
            private String lat;
            private String lng;

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getLng() {
                return lng;
            }

            public void setLng(String lng) {
                this.lng = lng;
            }
        }
    }


}

public class JsonParser1 {
    private static final String JSON = "[{\"id\":1,\"name\":\"VinayKumar\",\"username\":\"vinayk\",\"email\":\"vinayk@abcu.com\",\"address\":{\"street\":\"random1\",\"suite\":\"APR\",\"city\":\"Mumbai\",\"zipcode\":\"192008-13874\",\"geo\":{\"lat\":\"-17.3159\",\"lng\":\"91.1496\"}},\"website\":\"seuinfra.org\",\"company\":{\"name\":\"secinfra\",\"basename\":\"seuinfratech\"}},{\"id\":2,\"name\":\"AnanditaBasu\",\"username\":\"PrernaB\",\"email\":\"Anandita.b@abc1f.cpm\",\"address\":{\"street\":\"HawrohBridge\",\"suite\":\"ATY\",\"city\":\"Kolkata\",\"zipcode\":\"700001\",\"geo\":{\"lat\":\"-67.3159\",\"lng\":\"91.8006\"}},\"website\":\"techInfar.org\",\"company\":{\"name\":\"techinfarworld\",\"basename\":\"seuinfratech\"}},{\"id\":3,\"name\":\"CharviMalhotra\",\"username\":\"CharviM\",\"email\":\"Charvim@mail.net\",\"address\":{\"street\":\"whitehouseExtension\",\"suite\":\"A782\",\"city\":\"Bengaluru\",\"zipcode\":\"560001\",\"geo\":{\"lat\":\"-68.6102\",\"lng\":\"-47.0653\"}},\"website\":\"Infesystem.info\",\"company\":{\"name\":\"infeystems\",\"basename\":\"InformationEstsyem\"}},{\"id\":4,\"name\":\"PatriciaWilson\",\"username\":\"WilsonP\",\"email\":\"Wilsonp@mymail.org\",\"address\":{\"street\":\"Kalangut\",\"suite\":\"Apt6\",\"city\":\"Panjim\",\"zipcode\":\"403110\",\"geo\":{\"lat\":\"29.4572\",\"lng\":\"-164.2990\"}},\"website\":\"giant.Tech.biz\",\"company\":{\"name\":\"robert-techgiant\",\"basename\":\"transitioncutting-edgewebservicesprovider\"}},{\"id\":5,\"name\":\"ChetanChauhan\",\"username\":\"ChauhanChetan\",\"email\":\"chetanc@mailme.in\",\"address\":{\"street\":\"WillowWalks\",\"suite\":\"1351\",\"city\":\"Hyderabad\",\"zipcode\":\"500001\",\"geo\":{\"lat\":\"-31.8129\",\"lng\":\"62.5342\"}},\"website\":\"sanganak.info\",\"company\":{\"name\":\"Sanganak\",\"basename\":\"end-to-endsolutionprovider\"}},{\"id\":6,\"name\":\"PragyaMathur\",\"username\":\"mathurpragya\",\"email\":\"pragya.mathur@mail.in\",\"address\":{\"street\":\"RosewindCrossing\",\"suite\":\"A-50\",\"city\":\"Delhi\",\"zipcode\":\"100001\",\"geo\":{\"lat\":\"-71.4197\",\"lng\":\"71.7478\"}},\"website\":\"hola.in\",\"company\":{\"name\":\"HolaTechnocrafts\",\"basename\":\"e-enableinnovativeapplications\"}},{\"id\":7,\"name\":\"KrishAhuja\",\"username\":\"ahujakrish\",\"email\":\"ahujakrish@mails.in\",\"address\":{\"street\":\"HavmoreExtension\",\"suite\":\"A3221\",\"city\":\"Bengalura\",\"zipcode\":\"560058\",\"geo\":{\"lat\":\"24.8918\",\"lng\":\"21.8984\"}},\"website\":\"tellybelly.in\",\"company\":{\"name\":\"TellyBelly\",\"basename\":\"generateapplicationsupportsolutions\"}},{\"id\":8,\"name\":\"NilofarAnam\",\"username\":\"anamnilofar\",\"email\":\"nilofaranam.d@maily.me\",\"address\":{\"street\":\"fountainslane\",\"suite\":\"B902\",\"city\":\"pune\",\"zipcode\":\"400001\",\"geo\":{\"lat\":\"-14.3990\",\"lng\":\"-120.7677\"}},\"website\":\"techoba.com\",\"company\":{\"name\":\"TechHappyGroup\",\"basename\":\"e-supporttomiddleretailers\"}},{\"id\":9,\"name\":\"GarimaGupta\",\"username\":\"Garimag\",\"email\":\"gupta.garima22@myemails.io\",\"address\":{\"street\":\"LittlePark\",\"suite\":\"B68\",\"city\":\"Surat\",\"zipcode\":\"764920\",\"geo\":{\"lat\":\"24.6463\",\"lng\":\"-168.8889\"}},\"website\":\"contech.com\",\"company\":{\"name\":\"ConfigsTechs\",\"basename\":\"real-timetechnologiessupport\"}},{\"id\":10,\"name\":\"DharmaDhar\",\"username\":\"Dharmadhar55\",\"email\":\"dharmadhar55@olexa.in\",\"address\":{\"street\":\"AnamStreet\",\"suite\":\"198/23\",\"city\":\"Surat\",\"zipcode\":\"314280\",\"geo\":{\"lat\":\"-38.2386\",\"lng\":\"57.2232\"}},\"website\":\"ampitech.net\",\"company\":{\"name\":\"AmpitechSolutionsLtd\",\"basename\":\"targetend-to-endstartupsupport\"}}]";
    private static final String id = "id";
    private static final String EQUALS = "EQUALS";
    private static final String IN = "IN";


    public static List<Integer> apiResponseParser(List<String> inputList, int size) {
        List<Integer> result = new ArrayList<>();
        JsonArray array = new JsonParser().parse(JSON).getAsJsonArray();


        String fieldName = inputList.get(0);
        String fieldValue = inputList.get(2);
        String matcher = inputList.get(1);

        String[] fields = fieldName.split("\\.");

        int k = 0;
        int arraySize = array.size();
        for(int i = 0; i < arraySize; i++) {
            JsonObject current = array.get(i).getAsJsonObject();
            JsonObject temp = array.get(i).getAsJsonObject();

            String currentField = null;
            k = 0;
            while(k < fields.length) {
                currentField= fields[k];
                if(current.get(currentField).isJsonObject()) {
                    current = current.get(currentField).getAsJsonObject();
                }
                k++;
            }

            if(matcher.equals(EQUALS)) {
                String value = current.get(currentField).getAsString();
                if(value.equals(fieldValue)) {
                    result.add(Integer.parseInt(temp.get(id).toString()));
                }
            } else {
                String[] fieldValues = fieldValue.split(",");
                for(String currValue: fieldValues) {
                    String value = current.get(currentField).getAsString();
                    if(value.equals(currValue)) {
                        result.add(Integer.parseInt(temp.get(id).toString()));
                    }
                }
            }
        }

        if(result.isEmpty()) {
            result.add(-1);
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> inputList = new ArrayList<>();
        inputList.add("address.city");
        inputList.add("IN");
        inputList.add("Mumbai,Kolkata");

        List<Integer> ans = apiResponseParser(inputList, 3);

        System.out.println(ans);
    }
}
