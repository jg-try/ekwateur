# Lancement de l'application
Lancer le projet java avec la commande:
./mvnw spring-boot:run

3 clients sont créés automatiquement:
particulier:
- id: EKW1
- conso gaz: 1000kwh
- conso elec: 2000kwh

Pro n°1:
- id: EKW2
- CA: 40000€
- conso gaz: 1000kwh
- conso elec: 2000kwh

Pro n°3:
- id: EKW3
- CA: 4.000.000€
- conso gaz: 1000kwh
- conso elec: 2000kwh

# Test de l'API de Facturation
Tester le calcul de la facture via API REST:
http://localhost:8080/c/{clientId}/f/{month}/{year}

http://localhost:8080/c/EKW1/f/10/2023
http://localhost:8080/c/EKW2/f/10/2023
http://localhost:8080/c/EKW3/f/10/2023


# Amelioration
Distinction clients FR pour spécificités régionales