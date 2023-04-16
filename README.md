
# ControlCenter

A brief description of what this project does and who it's for



## Topics


For creation of incident listen to topic --> create-incident

For deletion of incident listen to topic --> delete-incident

For updating of incident listen to topic --> update-incident

## SpringBoot Run:

    ```
        gradle bootrun
    ```

## API Reference

#### Create an incident

```http
  POST /incident/create-incident
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `title` | `string` | **Required**. Title on incident |
| `description` | `string` | **Required**. Description of incident |
| `address` | `string` | **Required**. Location of incident |
| `phone` | `string` | **Required**. Phone number of creator |


#### Update an incident

```http
  POST /incident/update-incident
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of item to update |
| `title` | `string` | **Required**. Title on incident |
| `description` | `string` | **Required**. Description of incident |
| `address` | `string` | **Required**. Location of incident |
| `phone` | `string` | **Required**. Phone number of creator |

#### Delete an incident

```http
  DELETE /{incidentId}
```

#### Get all incidents

```http
  GET /incident/all
```


