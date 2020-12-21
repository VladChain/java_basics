public class Hospital {

    public static float[] generatePatientsTemperatures(int patientsCount) {

        float[] countOfPatient = new float[patientsCount];
        for (int i = 0; i < countOfPatient.length; i++)
            countOfPatient[i] = Math.round(32.0 + (Math.random() * (40.0 - 32.0)));
        for (float tempOfPatient : countOfPatient)
            System.out.print(tempOfPatient + " ");

        return countOfPatient;
    }

    public static String getReport(float[] temperatureData) {

        StringBuilder tempOfPatient = new StringBuilder();
        for (float allTemp : temperatureData)
            tempOfPatient.append(allTemp).append(" ");
        String allTemperature = tempOfPatient.toString().trim();

        float temp = 0;
        StringBuilder midTemp = new StringBuilder();
        for (float allTemp : temperatureData)
            temp += allTemp;
        temp = temp / 30;
        String result = String.format("%.1f", temp);
        midTemp.append(result);

        int patients = 0;
        StringBuilder healthPatients = new StringBuilder();
        for (float normalTemp : temperatureData)
            if (normalTemp >= 36 && normalTemp <= 37)
                patients++;
        healthPatients.append(patients);

        String report =
                "Температуры пациентов: " + allTemperature +
                        "\nСредняя температура: " + midTemp +
                        "\nКоличество здоровых: " + healthPatients;

        return report;
    }
}
