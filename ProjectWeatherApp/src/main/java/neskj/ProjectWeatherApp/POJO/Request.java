package neskj.ProjectWeatherApp.POJO;

public class Request {

    private String temp;
    private String feelsLike;
    private String tempMin;
    private String tempMax;

    public String getTemp() {
        return temp;
    }

    public String getFeelsLike() {
        return feelsLike;
    }

    public String getTempMin() {
        return tempMin;
    }

    public String getTempMax() {
        return tempMax;
    }

    @Override
    public String toString() {
        return " Temperature: "+temp+", Feels like: "+feelsLike+
                ", Temperature min: "+tempMin+", Temperature max: "+tempMax;
    }

    public static class Builder{

        private final Request request;

        public Builder(){

            this.request=new Request();
        }

        public Builder addTemp(String temp){

            request.temp=temp;
            return this;
        }

        public Builder addFeelsLike(String feelsLike){

            request.feelsLike=feelsLike;
            return  this;
        }

        public Builder addTempMin(String tempMin){

            request.tempMin=tempMin;
            return this;
        }

        public Builder addTempMax(String tempMax){

            request.tempMax=tempMax;
            return this;
        }

        public Request build(){

            return request;
        }
    }
}
