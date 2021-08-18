# SDLC (Software Development Lifecycle)
Process for planning, creating, and displaying information systems.

The high level steps:
1. Requirements Phase
    - If you have an existing system, you evaluate this system so that you can determine the various flaws that exist
    - You would consult w/ your clients, users, etc. on what functionalities they want in a new iteration of the application
    - Performed by Business Analyst (BAs)
2. Analysis Phase
    - This is the phase where we analyze the more technical aspects of the project, and it is where we define new system requirements
    - In particular, this is where we address the deficiencies with proposals for improvement
    - BAs + Senior members of the dev team
3. Design Phase
    - This is where we actually design the new system
    - No coding is done yet, the product features are planned out along with the system architecture
        - So this is where we might define our endpoints, API considerations
        - Draw out Entity Relationship Diagrams (ERDs)
        - What components we need to communicate with each other (ex. monolithic backend app + single database)
    - Architects and Senior devs
4. Development Phase
    - Software is built
    - Code is written
    - Junior devs and senior devs
5. Testing Phase
    - Software is tested to ensure it functions as intended
    - Devs & Testers
6. Deployment & Maintenance Phase
    - Product is actually delivered/deployed for the customer to use
    - Maintenance is rigorously kept up
        - This is where we have monitoring metrics, uptime reports, etc.
    - Operations Team

This is a high level overview of what steps we take during software development. However, the specific details change depending on what method we use to follow the SDLC.

# Waterfall Method
This is the traditional way of following the SDLC. The main idea is that we complete one phase entirely before moving onto the next phase. There is no going back to a previous phase once it is complete.

- Progress is seen as going "downwards" in one direction only
- Best suited for smaller projects or projects where requirements do not really change (Government projects)
- Often considered to not be efficient financial-wise
- Cannot go back up the waterfall
    - Waterfall is considered inflexible
- The benefits are that we get a full outline of the plan before we start
    - Everything is clear in terms of organization
- You don't deliver value until the very end of a project, where you actually deliver and deploy the application to the customer

Oftentimes, project managers love waterfall because it makes their jobs easier. If one phase takes longer than expected, all they need to do is adjust the next phases in terms of duration. However, for developers and testers, this could result in "crunch-time" and all sorts of inefficiencies and stress.

# Agile Method
Agile is another method for following the SDLC. By its name, you can tell that Agile is meant to be flexible. In particular, the main goal of Agile is to **deliver value faster**.

- Agile is based on iterative development where requirements and solutions evolve through the collaboration of cross-functional teams (and also customers)
- Agile is a philosophy/mentality
    - It's not something "we do", it's a mindset
    - But we do have frameworks built around the Agile mindset
- There are four key values to Agile (coming from the Agile manifesto)
    1. Individuals and interactions over processes and tools
    2. Working software over comprehensive documentation
        - We are not abandoning documentation
        - Documentation is still important, but only if it adds value to the usage of your application
    3. Customer collaboration over contract negotation
    4. Responding to change over following a plan
- There are Agile methods (also called frameworks), which are comprehensive approaches to "doing Agile"
    - Scrum is the most common
- Agile practices (closely tied to DevOps)
    - CI/CD or CI/CD/CD
    - Continuous Integration (CI)
        - The idea or process of continuously merging multiple developers' code into a repository frequently
            - For example, creating different branches for the features we're working on, pushing those branches, create pull requests, and then merge those feature branches into the main branch
        - This should happen MULTIPLE times per day. This is meant to prevent small issues from accumulating into large issues. The sooner we find issues, the less problems we will have down the road
        - CI can be automated to a certain extent
    - Continuous Delivery (CD)
        - This is where we automate the testing of the code in the main branch of our repository. We could then deploy the code at a "push of the button". This is only possible if all of our tests pass
        - With this approach, we generally have everything ready to be deployed, but we have a big "release day" where we actually deploy the new features
    - Continuous Deployment (CD)
        - Every change that we make to the codebase that passes all the stages of the product pipeline (and all of the tests we wrote) is released to the customer immediately. There is no "release day" because features keep being deployed continuously
        - This is valuable because it speeds up feedback that we can receive from the customer

# Scrum Methodology
Scrum is an Agile framework. It is a way of "doing Agile".

- In a "Scrum", the project is divided into "sprints"
- Sprint
    - A specified timeline (typically 2 weeks, but could be 1-4 weeks)
    - The timeline of the Sprint is agreed upon during a "Sprint planning meeting"
- User Story
    - Informal, natural language sentence/description of one or more features
    - User stories are written from the perspective of the user
    - They are agreed upon and split during the Sprint planning meeting
    - "As a user, when I log in as a regular employee using a valid username and password, I should be able to view all of my own reimbursement requests"
- Epic
    - A large body or collection of user stories

# Roles
- Product Owner
    - The product owner acts as the point of contact between the customer/client and the development team
    - The product owner is the one that prioritizes the user stories in the product backlog
- Scrum Master
    - Facilitator for the Scrum development team
    - Helps to clarify questions and organize the team
    - Spreading awareness and adoption of Scrum to everyone in the organization
- Dev Team: BAs, QAs, Coders
    - This is the team that estimates the amount of effort it would take to complete a user story
        - This has to do with the idea of story points
    - They are the ones who get the user story done
- Scrum Team
    - Dev Team + Product Owner + Scrum Master
    - Recommended team size 5 - 9 people

# Artifacts
- Product Backlog
    - This is a collection of all of the user stories that a particular project should have accomplished
    - These user stories in the backlog don't necessarily need to refined yet
        - Refinement would happen during Sprint planning, or as more details come in from the client
    - Typically we keep track of the product backlog using a tool such as Trello, Asana, Jira, etc.
        - Kanban board
- Sprint Backlog
    - A subset of the product backlog that contains the user stories to be completed during the current sprint
    - We choose what items should be completed and move them from the product backlog to the sprint backlog
- Burndown charts and burnup charts
    - Graphs that show how many user stories (or story points) are left to complete during the sprint
    - Burnup shows the amount completed so far which is the opposite of burndown

# Meetings (Scrum Rituals)
- Sprint Planning Meeting
    - Plan for what you want to accomplish during the sprint
    - Usually lasts around 4 hours
- Daily Standup Meeting
    - Short meeting that should last only 15 minutes at the most, and happens at the beginning of the day for a scrum team
    - EVERYONE should talk about what they did yesterday, what they plan to do today, and if they have any impediments (blockers)
        - A blocker is a person or group that you are waiting on to complete a certain task that you depend on for your own tasks being completed
    - Generally led by the scrum master
- Sprint Review Meeting
    - Happens at the end of the sprint
    - This is where features are showcased that were accomplished during the sprint
    - Here it is decided if the product is complete or needs additional work
- Sprint Retrospective Meeting
    - The scrum team meets and talks about what went well, what didn't go well, and what can be done to improve