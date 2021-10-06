# RewardsApp
Spring Boot API application to calculate and display customer rewards

## Usage
Application is a webservice and has following main URLs:

#### GET /rewards

Shows list of all customer with their monthly and total rewards.
```json
[
    {
        "customerId": 1,
        "rewardsMap": {
            "7-JULY": 7,
            "8-AUGUST": 388,
            "9-SEPTEMBER": 102,
            "Total": 497
        }
    },
    {
        "customerId": 2,
        "rewardsMap": {
            "7-JULY": 44,
            "8-AUGUST": 39,
            "9-SEPTEMBER": 745,
            "Total": 828
        }
    },
    {
        "customerId": 3,
        "rewardsMap": {
            "7-JULY": 38,
            "8-AUGUST": 842,
            "9-SEPTEMBER": 197,
            "Total": 1077
        }
    }
]
```

#### GET /rewards/{cusotmerId}
Shows monthly and weekly rewards for specified cusotmer ID.
```json
{
    "customerId": 2,
    "rewardsMap": {
        "7-JULY": 44,
        "8-AUGUST": 39,
        "9-SEPTEMBER": 745,
        "Total": 828
    }
}
```
#### GET /txns
List all the transactions in database
```json
[
    {
        "txnId": 1,
        "customerId": 1,
        "txnDate": "2021-09-10",
        "txnAmount": 112.56
    },
    {
        "txnId": 2,
        "customerId": 3,
        "txnDate": "2021-09-15",
        "txnAmount": 24.45
    },
    {
        "txnId": 3,
        "customerId": 2,
        "txnDate": "2021-07-22",
        "txnAmount": 30.12
    },
    {
        "txnId": 4,
        "customerId": 2,
        "txnDate": "2021-09-30",
        "txnAmount": 244.87
    },
    {
        "txnId": 5,
        "customerId": 1,
        "txnDate": "2021-07-11",
        "txnAmount": 57.02
    },
    {
        "txnId": 6,
        "customerId": 1,
        "txnDate": "2021-09-01",
        "txnAmount": 76.46
    },
    {
        "txnId": 7,
        "customerId": 3,
        "txnDate": "2021-08-12",
        "txnAmount": 315.78
    },
    {
        "txnId": 8,
        "customerId": 1,
        "txnDate": "2021-08-05",
        "txnAmount": 15.45
    },
    {
        "txnId": 9,
        "customerId": 2,
        "txnDate": "2021-09-16",
        "txnAmount": 67.31
    },
    {
        "txnId": 10,
        "customerId": 2,
        "txnDate": "2021-07-09",
        "txnAmount": 94.3
    },
    {
        "txnId": 11,
        "customerId": 1,
        "txnDate": "2021-08-18",
        "txnAmount": 146.87
    },
    {
        "txnId": 12,
        "customerId": 2,
        "txnDate": "2021-08-06",
        "txnAmount": 89.01
    },
    {
        "txnId": 13,
        "customerId": 1,
        "txnDate": "2021-08-19",
        "txnAmount": 197.08
    },
    {
        "txnId": 14,
        "customerId": 2,
        "txnDate": "2021-09-14",
        "txnAmount": 269.09
    },
    {
        "txnId": 15,
        "customerId": 1,
        "txnDate": "2021-07-23",
        "txnAmount": 20.34
    },
    {
        "txnId": 16,
        "customerId": 3,
        "txnDate": "2021-08-12",
        "txnAmount": 210.1
    },
    {
        "txnId": 17,
        "customerId": 3,
        "txnDate": "2021-07-25",
        "txnAmount": 49.13
    },
    {
        "txnId": 18,
        "customerId": 3,
        "txnDate": "2021-08-27",
        "txnAmount": 120.0
    },
    {
        "txnId": 19,
        "customerId": 3,
        "txnDate": "2021-09-27",
        "txnAmount": 88.9
    },
    {
        "txnId": 20,
        "customerId": 3,
        "txnDate": "2021-07-25",
        "txnAmount": 61.36
    },
    {
        "txnId": 21,
        "customerId": 3,
        "txnDate": "2021-09-29",
        "txnAmount": 154.0
    },
    {
        "txnId": 22,
        "customerId": 3,
        "txnDate": "2021-07-26",
        "txnAmount": 77.12
    }
]
```
