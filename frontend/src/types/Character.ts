// Definimos el tipo. Es nuestro "dto" del front
// Nuestro CharacterApiDto del back refleja esto, por tanto el front
// debe tener tambien algo para poder representar justo, lo que queremos

export interface Character {
  id: number
  name: string
  status: string
  species: string
  image: string
}
